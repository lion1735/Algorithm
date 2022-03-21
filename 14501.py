N = int(input())

timeTable = [list(map(int, input().split())) for _ in range(N)]

dp = [0 for _ in range(N+1)]

for i in range(N-1, -1, -1):
    if i + timeTable[i][0] > N:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(timeTable[i][1] + dp[i + timeTable[i][0]], dp[i+1])

print(dp[0])
