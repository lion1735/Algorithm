# 우상, 우, 우하, 하 - 3가지 방향만 고려
dx = [-1, 0, 1, 1]
dy = [1, 1, 1, 0]
board = [list(map(int, input().split(" "))) for _ in range(19)]
SIZE = 19

def isCheck(x, y): # 범위 체크
    return 0 <= x < SIZE and 0 <= y < SIZE

def bfs(x, y, color): #오목을 찾았을 때 bfs
    for k in range(len(dx)):
        bx = x - dx[k]
        by = y - dy[k]
        if not isCheck(bx, by) or board[bx][by] != color: #범위 밖이거나 색깔이 다르면 해도됨.
            nx = x + dx[k]
            ny = y + dy[k]
            cnt = 1 #시작.
            while True: #같은 방향으로 쭉 확인하기
                if isCheck(nx, ny) and board[nx][ny] == color:
                    cnt += 1
                else: 
                    break
                nx += dx[k]
                ny += dy[k]
            if cnt == 5: #cnt 가 5보다 크면 안되는거.
                return True
    return False

def func(): #오목 찾기
    for i in range(SIZE):
        for j in range(SIZE):
            if board[i][j] != 0 and bfs(i, j, board[i][j]):
                    return board[i][j], [i+1,j+1]
    return 0, 0


color, position = func()
if color != 0:
    print(color)
    print(*position)
else:
    print(color)
