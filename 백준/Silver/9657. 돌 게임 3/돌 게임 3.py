N = int(input())
player = 'SK'
enem = 'CY'
if N == 1 or N == 3 or N == 4 or N == 5:
    print(player)
    exit()
if N == 2:
    print(enem)
    exit()

dp = [0] * (N + 1)

dp[1] = player
dp[2] = enem
dp[3] = player
dp[4] = player
dp[5] = player



for i in range(6, N+1):

    if dp[i-1] == enem or dp[i-3] == enem or dp[i-4] == enem:
        dp[i] = player
    else:
        dp[i] = enem

print(dp[-1])