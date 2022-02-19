n = int(input())
for i in range(n):
    s = input()
    l=0
    r=(len(s)-1)
    ptr = 0
    ptrL =1
    ptrR =1
    while l<r:
        # print(s[l],s[r])
        if ptr > 0:
            break
        if s[l]==s[r]:
            l+=1
            r-=1
        elif s[l]==s[r-1] or s[l+1]==s[r]:
            l2 = l
            r2 = r-1
            ptr +=1
            while l2<r2:
                if s[l2]==s[r2]:
                    l2 += 1
                    r2 -= 1
                else:
                    ptrL = 2
                    break
            l2 = l+1
            r2 = r
            while l2<r2:
                if s[l2]==s[r2]:
                    l2 += 1
                    r2 -= 1
                else:
                    ptrR = 2
                    break
            res = min(ptrL,ptrR)
            ptr = res
        else:
            ptr=2
    print(ptr)
