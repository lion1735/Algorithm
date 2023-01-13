from itertools import permutations

n, m = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
res = {}
for i in permutations(arr,m):
    res[i] = 0
for i in res.keys():
    i = str(i)
    print(i[1:-1].replace(',',''))
