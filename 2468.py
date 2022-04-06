# 높이가 4 이하인 지점
# 가장 큰값부터 가장 작은값까지 물에 잠기는 범위
# 가장 많은 안전 영역을 만들어라

# 매번 맵을 생성하고 높이를 설정해서 bfs로 탐색하기
import sys
sys.setrecursionlimit(15000)


def dfs(y,x):
    global visited
    # if 0 > y or 0 > x or y >= n or x >= n or visited[y][x]: return

    visited[y][x] = True
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0<= ny < n and 0<=nx<n and not visited[ny][nx]:
            dfs(ny,nx)
    return

dy = [-1,1,0,0]
dx = [0,0,-1,1]

n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]
ans = 0
for rain in range(1,101):
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    # 물에 잠기기
    for i in range(n):
        for j in range(n):
            if arr[i][j] < rain:
                visited[i][j] = True
    #영역 체크하기 
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and arr[i][j] >= rain:
                dfs(i,j)
                cnt += 1
    
    ans = max(ans,cnt)
print(ans)
