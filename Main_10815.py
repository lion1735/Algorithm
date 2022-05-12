n = int(input())
arr = sorted(list(map(int,input().split())))
m = int(input())
li = list(map(int,input().split()))
for num in li:
    s = 0
    e = n-1
    ans = 0
    while s<=e:
        mid = (s+e)//2
        if arr[mid] == num:
            ans =1
            break
        elif arr[mid] > num:
            e = mid-1
        elif arr[mid] < num:
            s = mid+1
    print(ans,end=' ')
