import sys
sys.setrecursionlimit(10**6)
n, m, k = map(int,input().split())
arr = [0] + list(map(int,input().split()))
v =[[]for i in range(n+1)]

for i in range(m):
    a,b = map(int,input().split())
    v[a].append(b)
    v[b].append(a)

visited = [False for i in range(n+1)]

def dfs(cur):
    ret = arr[cur]
    visited[cur] = True

    for nxt in v[cur]:
        if visited[nxt]:
            continue

        ret = min(ret,dfs(nxt))

    return ret

ans = 0
for i in range(1,n+1):
    if visited[i]:
        continue
    ans += dfs(i)
if ans <= k:
    print(ans)
else:
    print("Oh no")
