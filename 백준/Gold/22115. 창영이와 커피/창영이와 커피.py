import sys
input = sys.stdin.readline
N, K = map(int, input().split())

caffeine_content = list(map(int, input().split()))
caffeine_content.insert(0,0)
inf = 1e9
dp = [[ inf for _ in range(K + 1)] for _ in range(N + 1)]


for i in range(N):
    dp[i][0] = 0

for coffee_index in range(1,N + 1):
    for total_caffeine in range(1,K + 1):
        caffeine = caffeine_content[coffee_index]
        if total_caffeine - caffeine >= 0:
            dp[coffee_index][total_caffeine] = min(dp[coffee_index - 1][total_caffeine],
                    dp[coffee_index - 1][total_caffeine - caffeine] + 1)
        else:
            dp[coffee_index][total_caffeine] = dp[coffee_index - 1][total_caffeine]

if (K == 0):
    print(0)
elif dp[N][K] == inf:
    print(-1)
else:
    print(dp[N][K])
