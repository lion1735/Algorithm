# N 중 탐색
# DFS로 짜보쟈 X 못 찾으면 어케 알아?
# BFS로 해야겠네

from collections import deque
from pprint import pprint

def isCheck(z,y,x):
    return 0<= z < t and 0<= y < n and 0<= x  < m

def bfs(z,y,x):
    que = deque()
    que.append([z,y,x,0])
    arr[z][y][x] = '#'

    while que:
        temp = que.popleft()
        for d in range(len(dz)):
            nz = temp[0] + dz[d]
            ny = temp[1] + dy[d]
            nx = temp[2] + dx[d]
            cnt = temp[3] +1
            if isCheck(nz,ny,nx):
                if arr[nz][ny][nx] == 'E':
                    return cnt
                elif arr[nz][ny][nx] == '.' :
                    que.append([nz,ny,nx, cnt])
                    arr[nz][ny][nx] = '#'
    return -1

dz = [-1,1,0,0,0,0]
dy = [0,0,-1,0,1,0]
dx = [0,0,0,-1,0,1]


while True:
    t, n, m = map(int,input().split())
    if t==0 and n==0 and m ==0: break

    arr = [[[[0] for _ in range(m)] for _ in range(n) ] for _ in range(t)]
    for i in range(t):
        arr[i] = [list(map(str,input().strip())) for _ in range(n)]
        input() # 한줄 빼기
    for i in range(t):
        for j in range(n):
            for k in range(m):
                if arr[i][j][k] == 'S':
                    res = bfs(i,j,k)
                    if res != -1:
                        print('Escaped in',res,'minute(s).')
                    else:
                        print('Trapped!')

