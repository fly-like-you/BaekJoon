N = int(input())
if N == 1 or N == 2:
    print(1)
    exit()
elif N == 3:
    print(2)
    exit()
elif N == 4:
    print(3)
    exit()
dp = [(0, 0)] * (N + 1)
dp[2] = (1, 0)
dp[3] = (1, 1)

for i in range(4, N+1):
    zero = dp[i-1][0]
    one = dp[i-1][1]

    dp[i] = (zero + one, zero)

print(dp[-1][0] + dp[-1][1])