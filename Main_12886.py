'''
관찰 
1. 10 15 35
2. 20 15 25 -> 15 20 25
3. 30 20 10 -> 10 20 30
4. 20 20 20 O

모든 경우의 수를 다 넣어보고 돌려야 할 듯?
d = [[0,1,2],[0,2,1],[1,2,0]]

def recur(arr):
    arr.sort()
    print(arr)
    if arr[0] <0:
        return
    if arr[0] == arr[1] and arr[1] == arr[2]:
        print(1)
        exit()

    for i in range(len(d)):
        nx = arr[d[i][0]]
        ny = arr[d[i][1]]
        nz = arr[d[i][2]]
        if nx < ny:
            recur([nx*2,ny-nx,nz])
        
x,y,z = map(int,input().split())
recur([x,y,z])
print(0)
'''
from collections import deque


d = [[0,1,2],[0,2,1],[1,2,0]] #조합

def bfs(arr):
    que = deque()
    que.append(arr)
    visited = [[False for _ in range(2001)] for _ in range(2001)] #같은 수를 반복되서 넣음
    while que:
        temp = sorted(que.pop()) #정렬해놓고 d처럼 조합 돌리기
        
        if temp[0] == temp[1] and temp[1] == temp[2]: # 정답을 찾았는지?
            return 1

        for i in range(len(d)):
            nx,ny,nz = temp[d[i][0]],temp[d[i][1]],temp[d[i][2]] #큐에서 변할 수 있는 값들
            if not visited[nx*2][ny-nx]: # 방문하지 않았다면 큐에 넣기
                que.append([nx*2,ny-nx,nz])
                visited[nx*2][ny-nx] = True
        
    return 0

x,y,z = map(int,input().split())
print(bfs([x,y,z]))
