n, m = map(int, input().split())
li = [int(input()) for i in range(n)]

l = 1
r = max(li)
while l <= r:
    cnt = 0
    mid = (l + r)//2
    for x in li:
        cnt += x//mid
    if cnt >= m:
        l = mid + 1
    else:
        r = mid - 1
        
print(r)

