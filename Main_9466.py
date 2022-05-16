'''
1-3
2-1
3-3
4-7
5-3
6-4
7-6

연결 정보를 DFS로 탐색해서 자기 자신이 오면 되겠나?
from pprint import pprint
import sys
sys.setrecursionlimit(2500) 

def dfs(num):
    global hap
    visited[num] = True #방문한 숫자 체크
    li.append(num) # 연결되는 링크 만들어주기
    print(num, arr[num]) 
    if arr[num] == num: #만약에 자기를 가르키는 숫자라면?
        li.pop()
    
    if not visited[arr[num]]: #방문하지 않았다면?
        dfs(arr[num])
    elif li: #방문 했고 li가 존재한다면
        print(li)
        cnt = 0
        for i in range(len(li)):
            if li[i] != arr[i]:
                cnt+=1
            else:
                hap += cnt
                return
    hap += len(li)
    return

t = int(input())
for _ in range(t):
    n = int(input())
    arr = [0] + list(map(int, input().split())) #패딩
    visited = [False] * (n + 1)
    hap = 0
    for i in range(1, n + 1): #인덱스 시작
        li = []
        if not visited[i]:
            dfs(i)

    print(hap)
'''
from pprint import pprint
import sys
sys.setrecursionlimit(100001) 

def dfs(num):
    global hap
    visited[num] = True #방문한 숫자 체크
    li.append(num) # 연결되는 링크 만들어주기
    if visited[arr[num]]: #방문했다면?
        if arr[num] in li: #특정 노드에 방문했는데 그 노드가 이미 연결되있다면?
            hap += len(li[li.index(arr[num]):]) #li의 인덱스들 더해주기
            # print(arr[num], li)
            # print("test : ",li[li.index(arr[num]):])
        return
    else: #방문 안했다면?
        dfs(arr[num])


t = int(input())
for _ in range(t):
    n = int(input())
    arr = [0] + list(map(int, input().split())) #패딩
    visited = [False] * (n + 1)
    hap = 0
    for i in range(1, n + 1): #인덱스 시작
        if not visited[i]:
            li = []
            dfs(i)

    print(n-hap)
