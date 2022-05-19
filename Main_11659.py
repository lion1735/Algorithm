import sys
input = sys.stdin.readline

n, m = map(int,input().split())
li = list(map(int,input().split()))
prefix = [0]
for i in range(1,n+1):
    prefix.append(prefix[i-1]+li[i-1])
for i in range(m):
    a,b = map(int,input().split())
    print(prefix[b]-prefix[a-1])
