n = int(input())
res = []
cnt =0

for x in range(2,int(n**0.5)+2):
    if x > n:
        break
    while n%x==0:
        res.append(x)
        n//=x
        cnt+=1
if n!=1:
    res.append(n)
print(len(res))
print(*res)
 
