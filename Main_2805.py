def check(x):
    total = 0
    for i in arr:
        total += max(0, i-x)
    return total >= m

n, m = map(int,input().split())
arr = list(map(int,input().split()))

s = 0 
e = 1000000001
ans = 0
while s<= e:
    mid = (s+e) //2

    if check(mid):
        ans = mid
        s = mid +1
    else:
        e = mid -1

print(ans)
