n, m = map(int, input().split())
liA = set()
liB = set()
for i in range(n):
    liA.add(input())
for i in range(m): 
    liB.add(input())
res = sorted(list(liA & liB))
print(len(res))
for x in res:
    print(x)
