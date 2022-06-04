from collections import deque

def bfs(num,n):
  arr=[0]*(n+1)
  visited=[num]
  que=deque()
  que.append(num)

  while que:
    k=que.popleft()
    for i in relation[k]:
      if i not in visited:
        arr[i]=arr[k]+1
        visited.append(i)
        que.append(i)
  
  return sum(arr)


n,m=map(int, input().split())
relation={i:[] for i in range(1,n+1)}
for i in range(m):
  a,b=map(int, input().split())
  relation[a].append(b)
  relation[b].append(a)

result=[]
for num in range(1,n+1):
  result.append(bfs(num,n))
# print(relation)
print(result.index(min(result))+1)
