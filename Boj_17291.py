n = int(input())
dp = [1,1,2,4,7]
for i in range(4,n):
    if i%2==1:
        dp.append(dp[i-2]+dp[i-1]+dp[i-0])
    else:
        dp.append(dp[i-3]+dp[i-2]+dp[i-1]+dp[i-0])
print(dp[n])
