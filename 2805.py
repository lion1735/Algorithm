n, m = map(int, input().split())
li = list(map(int, input().split()))

l = 1
r = max(li)
while l <= r:
    cnt = 0
    hap = 0
    mid = (l + r)//2
    for x in li:
        if x - mid > 0:
            cnt += x - mid
    if cnt >= m:
        l = mid + 1
    else:
        r = mid - 1
print(r)
