
'''
0 : CBADEF
1 : CBDAEF
2 : CDBEAF
3 : DCEBFA

3 4
JLA
CRUO
3
'''
n, m = map(int,input().split())
arrA = list(map(str,input()))
arrB = list(map(str,input()))
arrA.reverse()
res = arrA + arrB
for _ in range(int(input())):
    for i in range(len(res)-1):
        if res[i] in arrA and res[i+1] in arrB:
            res[i],res[i+1] = res[i+1],res[i]
            if res[i+1] == arrA[-1]:
                break
print("".join(res))
