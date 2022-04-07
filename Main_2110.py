# mid = 거리
# total = 공유기 갯수

def check(x):
    total = 1
    center = 0
    for i in range(1,len(arr)):
        if(x <= arr[i]-arr[center]):
            center = i
            total += 1
    # print('X : ', x , ' total : ',total)
    return total >= m

n, m = map(int,input().split())
arr = [int(input()) for _ in range(n)]
arr.sort()
s = 0
e = 1000000001
ans = 0
while s<= e:
    mid = (s+e) // 2
    
    if(check(mid)):
        ans = mid
        s = mid + 1
    else:
        e = mid - 1
print(ans)
