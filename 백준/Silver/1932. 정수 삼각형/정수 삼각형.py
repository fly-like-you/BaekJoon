

N = int(input())

triangle = [ list(map(int, input().split())) for i in range(N) ]
dp = [ [ 0 for j in range(N) ] for i in range(N) ]

dp[0][0] = triangle[0][0]
for i in range(1,N): # 세로축
    dp[i][0] += triangle[i][0] + dp[i-1][0]
    dp[i][i] += triangle[i][i] + dp[i-1][i-1]
    for j in range(1,i): # 가로축
        dp[i][j] += triangle[i][j] + max(dp[i-1][j-1], dp[i-1][j])

maxi = 0
for i in range(N):
    dp[i].sort(reverse=True)
    if dp[i][0] > maxi:
        maxi = dp[i][0]
print(maxi)