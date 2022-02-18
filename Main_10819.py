def recur(cur):
    if cur ==n:
        global maxHap
        hap = 0
        for i in range(len(res)-1):
            hap += abs(res[i]-res[i+1])
        maxHap = max(maxHap,hap)
        return
    
    for i in range(n):
        if v[i]: continue
        v[i] = True
        res[cur] = li[i]
        recur(cur+1)
        v[i] = False
        
maxHap = 0
n = int(input())
li = list(map(int,input().split()))
res = [0 for i in range(n)]
v = [False for i in range(n)]

recur(0)
print(maxHap)
