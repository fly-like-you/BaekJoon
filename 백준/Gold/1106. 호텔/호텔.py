C, N = map(int, input().split())
promotion_cost = []
promoted_client = []
for _ in range(N):
    cost, client = map(int, input().split())
    promotion_cost.append(cost)
    promoted_client.append(client)
# C는 최소 인원
inf = 100 * 1000
dp = [100 * C for _ in range(C + 100)]
dp[0] = 0
for i in range(N):
    num_people = promoted_client[i]
    for j in range(num_people, C + 100):
        dp[j] = min(dp[j-num_people] + promotion_cost[i], dp[j])
print(min(dp[C:]))

