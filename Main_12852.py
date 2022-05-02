'''
DP + 역추적인가?!
흠 DP 테이블을 ptr 값으로 놓고 역으로 큰 수가 나오면?
1퍼틀..
n = int(input())
dp = [0, 0, 1]
for i in range(3, n+1):
    if i % 6 == 0:
        dp.append(min(dp[i//3]+1, dp[i//2]+1, dp[i-1]+1))
    elif i % 3 == 0:
        dp.append(min(dp[i//3]+1, dp[i-1]+1))
    elif i % 2 == 0:
        dp.append(min(dp[i//2]+1, dp[i-1]+1))
    else:
        dp.append(dp[i-1]+1)

print(dp[n])
ptr =dp[n]
for i in range(len(dp)-1,0,-1):
    if dp[i] == ptr:
        print(i,end=' ')
        ptr-= 1
역추적...어떤 값으로 계산되었을때? 그 값을 저장하자.
그러면 i%2 인지 i%3 인지를 정확히 알고있어야 되나?
12 라는 숫자가 들어왔을때 11과 4와 6을 비교해서 인덱스가 작은거 체크하기

n = int(input())
dp = [0, 0, 1]
for i in range(3, n+1):
    if i % 6 == 0:
        dp.append(min(dp[i//3]+1, dp[i//2]+1, dp[i-1]+1))
    elif i % 3 == 0:
        dp.append(min(dp[i//3]+1, dp[i-1]+1))
    elif i % 2 == 0:
        dp.append(min(dp[i//2]+1, dp[i-1]+1))
    else:
        dp.append(dp[i-1]+1)

print(dp[n])
ptr =dp[n]
nx = n

while nx != 1:
    print(nx, end=' ')
    if nx%6 == 0:
        if dp[n//3] < dp[n//2]:
            ptr = dp[n//3]
            nx = nx//3
        else:
            ptr = dp[n//2]
            nx = nx//2
    elif nx%3 == 0:
        if dp[n//3] < dp[n-1]:
            ptr = dp[n//3]
            nx = nx//3
        else:
            ptr = dp[n-1]
            nx = nx-1
    elif nx%2 == 0:
        if dp[n//2] < dp[n-1]:
            ptr = dp[n//2]
            nx = nx//2
        else:
            ptr = dp[n-1]
            nx = nx-1
    else:
        ptr = dp[n-1]
        nx = nx-1
print(1, end=' ')
'''
n = int(input())
dp = [0, 0, 1]
for i in range(3, n+1):
    if i % 6 == 0:
        dp.append(min(dp[i//3]+1, dp[i//2]+1, dp[i-1]+1))
    elif i % 3 == 0:
        dp.append(min(dp[i//3]+1, dp[i-1]+1))
    elif i % 2 == 0:
        dp.append(min(dp[i//2]+1, dp[i-1]+1))
    else:
        dp.append(dp[i-1]+1)

print(dp[n])
ptr =dp[n]
nx = n
# 나누어 떨어진다면 비교할 순 없나..
while nx != 1:
    print(nx, end=' ')
    if nx%6 == 0:
        if dp[n//3] < dp[n//2]:
            ptr = dp[n//3]
            nx = nx//3
        elif dp[n//3] > dp[n//2]:
            ptr = dp[n//2]
            nx = nx//2
    elif nx%3 == 0:
        if dp[n//3] < dp[n-1]:
            ptr = dp[n//3]
            nx = nx//3
        else:
            ptr = dp[n-1]
            nx = nx-1
    elif nx%2 == 0:
        if dp[n//2] < dp[n-1]:
            ptr = dp[n//2]
            nx = nx//2
        else:
            ptr = dp[n-1]
            nx = nx-1
    else:
        ptr = dp[n-1]
        nx = nx-1
print(1, end=' ')
