import sys
n, m = map(int, sys.stdin.readline().rstrip().split())
li = [[0 for _ in range(n+1)]] + [[0]+list(map(int, sys.stdin.readline().rstrip().split()))
                                  for _ in range(n)]
prefix = [[0 for _ in range(n+1)]for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        prefix[i][j] = li[i][j] + prefix[i][j-1] + \
            prefix[i-1][j] - prefix[i-1][j-1]


for _ in range(m):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().rstrip().split())
    hap = prefix[x2][y2] - prefix[x2][y1-1] - \
        prefix[x1-1][y2] + prefix[x1-1][y1-1]
    print(hap)
