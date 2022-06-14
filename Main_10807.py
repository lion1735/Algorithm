n = int(input())
arr = [0 for _ in range(201)]
for i in list(map(int,input().split())):
    arr[i+100] += 1
print(arr[int(input())+100])
