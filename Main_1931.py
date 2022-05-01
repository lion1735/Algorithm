n = int(input())
li = []
for i in range(n):
    A, B = map(int, input().split())
    li.append([A, B])
li.sort(key = lambda x : (x[1] , x[0]))
# print(s)
last = 0
cnt = 0
for i, j in li:
    if i >= last:
        cnt += 1
        last = j
print(cnt)
