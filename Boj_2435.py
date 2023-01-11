
n, m = map(int,input().split())
arr = list(map(int,input().split()))
result = -1000000
l = 0
hap = 0
for i in range(0,m):
    hap += arr[i]

result = max(result,hap)
for i in range(m,len(arr)):
    hap += arr[i]
    hap -= arr[l]
    result = max(result,hap)
    l+=1
print(result)
