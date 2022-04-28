n = int(input())
li = {}
for i in range(n):
    temp = input()
    if temp in li:
        li[temp] += 1
    else:
        li[temp] = 1
arr = []
for temp in li:
    arr.append([temp,li[temp]])
arr.sort(key = lambda x :(-x[1], x[0]))
print(arr[0][0])
