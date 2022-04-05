n, m = map(int, input().split())
x, y, d = map(int, input().split())
arr = [list(map(int, input().split())) for i in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cnt = 0

while True:
    if arr[x][y] == 0: # 청소를 해야한다면 카운팅
        cnt += 1

    arr[x][y] = 2 # 지나온곳은 2로 변환
 
    flag = False 
    for i in range(4):
        d = (d + 3) % 4

        nx = x + dx[d]
        ny = y + dy[d]

        if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 0: #가야할 위치라면
            flag = True #위치를 찾았는지 체크하기 위해서
            break

    if flag:
        x += dx[d]
        y += dy[d]
    else: #4방향 탐색이 되지 않았음
        nx = x - dx[d]
        ny = y - dy[d]

        if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 2: #청소 O 갈수있음 O
            x = nx
            y = ny
        else:
            break

print(cnt)
