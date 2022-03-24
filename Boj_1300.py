def check(x):
    total = 0
    for i in range(1, n+1):
        total += min(n, x//i)
    return total >= m


n = int(input())
m = int(input())

s = 1
e = n * n
while s <= e:
    mid = (s+e)//2
    if check(mid):
        ans = mid
        e = mid-1
    else:
        s = mid+1

print(ans)
