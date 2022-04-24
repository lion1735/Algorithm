def recur(cur, s):
    if cur == n:          
        res.add(" ".join(list(map(str, li)))) #int 를 str로 변환해서 배열로 담기
        return

    if len(li) > m:
        return

    for i in range(s, len(arr)):     
        if not v[i]: 
            li[cur] = arr[i] 
            v[i] = True
            recur(cur + 1, i)
            v[i] = False


m, n = map(int, input().split())
arr = sorted(list(map(int, input().split())))
v = [False for _ in range(m+1)]
li = [0 for i in range(n)]
res = set() # set 은 순서를 보장하지 않는..다
recur(0, 0)
res = list(res) #set을 list로 변환
for i in range(len(res)): 
    res[i] = list(map(int,res[i].split())) #str을 다시 int로 변환
if n > 1: #인덱스 에러 방지용
    res.sort(key = lambda x :(x[0],x[1])) #배열 정렬
for i in res: 
    print(*i)
