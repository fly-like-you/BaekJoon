T = int(input())

for _ in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    M = int(input())
    coins.insert(0,0)
    dp = [[ 0 for _ in range(M + 1)] for _ in range(N + 1)]
    for i in range(N + 1):
        dp[i][0] = 1
    for coin_index in range(1,N+1):
        for money in range(1,M+1):
            dp[coin_index][money] = dp[coin_index - 1][money]
            if money - coins[coin_index] >= 0:
                dp[coin_index][money] += dp[coin_index][money - coins[coin_index]]
    print(dp[N][M])