K, N = map(int, input().split())

W = [0]
V = [0]
for _ in range(N):
    temp1, temp2 = map(int, input().split())
    V.append(temp1)
    W.append(temp2)

dp = [ [ 0 for _ in range(K + 1)] for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, K + 1):
        if j >= W[i]:
            dp[i][j] = max(dp[i-1][j-W[i]] + V[i], dp[i-1][j])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[N][K])