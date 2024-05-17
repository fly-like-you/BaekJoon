N = int(input())
if N == 1 or N == 3:
    print('CY')
    exit()
if N == 4 or N == 2:
    print('SK')
    exit()

dp = [0] * (N + 1)

dp[1] = 'CY'
dp[2] = 'SK'
dp[3] = 'CY'
dp[4] = 'SK'



for i in range(5, N+1):

    if dp[i-1] == 'CY' or dp[i-3] == 'CY':
        dp[i] = 'SK'
    else:
        dp[i] = 'CY'

print(dp[-1])