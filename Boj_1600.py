# 파이썬으로 BFS는 처음이라...
'''
3차원을 사용해야하는 이유? 무조건 말을 다 쓴다고 되지는 않을듯
BFS 특성상 해당 위치에 오는게 가장 작은 값
'''
def isCheck(y, x, h):
    return 0 <= y < m and 0 <= x < n and 0 <= h <= cnt

from collections import deque

cnt = int(input())
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for i in range(m)]
que = deque()
# cnt만큼 이동 할 수 있으므로 
visited = [[[False for i in range(cnt + 1)]
            for _ in range(n)] for _ in range(m)]

# 원숭이만 넣는 경우도 있기때문에 둘 다 돌려보기 위함.
dx = [[1, 0, -1, 0], [-2, -2, -1, -1, 1, 1, 2, 2]] 
dy = [[0, 1, 0, -1], [-1, 1, -2, 2, -2, 2, -1, 1]]


res = 0
que.append([0, 0, 0])  # que 배열로 선언하기 []
visited[0][0][0] = True
while que:
    for _ in range(len(que)):
        y, x, h = que[0][0], que[0][1], que[0][2]
        que.popleft()
        if y == m-1 and x == n-1:
            print(res)
            exit()
        for i in range(2):
            for j in range(len(dx[i])):
                ny = y + dy[i][j]
                nx = x + dx[i][j]
                nh = h + i

                if not isCheck(ny, nx, nh) or visited[ny][nx][nh] or arr[ny][nx] != 0:
                    continue

                que.append([ny, nx, nh])
                visited[ny][nx][nh] = True

    res += 1
print(-1)
