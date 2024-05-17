N = int(input())
if N == 1 or N == 3:
    print('SK')
    exit()
if N == 4 or N == 2 :
    print('CY')
    exit()

dp = [0] * (N + 1)

dp[1] = 'SK'
dp[2] = 'CY'
dp[3] = 'SK'
dp[4] = 'CY'



for i in range(5, N+1):

    if dp[i-1] == 'CY' or dp[i-3] == 'CY':
        dp[i] = 'SK'
    else:
        dp[i] = 'CY'

print(dp[-1])