from collections import deque

dy = [1,0,-1,0]
dx = [0,1,0,-1]

def in_Range(y,x):
    global n,m
    return 0<=y <n and 0<=x<m

def bfs():
    global hap
    visited = [[[False for _ in range(m)] for _ in range(n)] for _ in range(3)]
    que = deque()
    cnt = [] #복치를 몇 마리 찾았니?
    for i in range(len(bokchies)):
        y = bokchies[i][0]
        x = bokchies[i][1]
        que.append([i,y,x,0])
        visited[i][y][x] = True
    while que:
        bokchi,y,x,dist = que.popleft() #몇 번째 복치, y좌표, x좌표, 이동거리
        
        if bokchi in cnt : #이미 자리를 찾았니?
            continue
        if arr[y][x] == 'B' or arr[y][x] =='C' or arr[y][x] =='_':
            arr[y][x] = '.'
            hap += dist
            cnt.append(bokchi)
            if len(cnt) == 3:
                return hap
        for dir in range(4):
            ny = y + dy[dir]
            nx = x + dx[dir]
            if not in_Range(ny,nx) or arr[ny][nx] == '#' or visited[bokchi][ny][nx]:
                continue
            que.append([bokchi,ny,nx,dist+1])
            visited[bokchi][ny][nx] = True

    return -1

tc = int(input())
for testCase in range(tc):
    hap = 0
    n,m = map(int,input().split())
    arr = [list(input()) for _ in range(n)]
    bokchies = []
    
    for i in range(3):
        by,bx = map(int,input().split())
        bokchies.append([by-1,bx-1])
    print(f'#{testCase+1} {bfs()}')
