maxNum = int(input())
li = list(map(int,input().split()))
n = int(input())
for i in range(n):
    gender, num = map(int,input().split())
    if gender == 1:
        ptr = num
        while num-1 < maxNum:
            li[num-1] = (li[num-1] + 1 )% 2
            num += ptr
    elif gender == 2:
        ptr = 1
        li[num-1] = (li[num-1] + 1 )% 2
        while num-ptr-1 >= 0 and num+ptr-1 < maxNum and li[num-ptr-1] == li[num+ptr-1]:
            li[num-ptr-1] = (li[num-ptr-1] + 1 )% 2
            li[num+ptr-1] = (li[num+ptr-1] + 1 )% 2
            ptr+=1

# print(*li)
# print("-----------")
for i in range(1,len(li)+1):
    print(li[i-1],end=' ')
    if i%20==0:
        print()
