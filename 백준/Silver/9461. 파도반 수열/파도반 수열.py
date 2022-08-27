N = int(input())
dp = [0,1,1,1,2,2,3,4]

for i in range(8, 101):
    dp.append(dp[i-5] + dp[i-1])
for i in range(N):
    q = int(input())
    print(dp[q])

