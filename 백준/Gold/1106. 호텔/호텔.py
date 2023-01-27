C, N = map(int, input().split())
promotion_cost = [0]
promoted_client = [0]
for _ in range(N):
    cost, client = map(int, input().split())
    promotion_cost.append(cost)
    promoted_client.append(client)

inf = 100 * 1000
dp = [ [ 0 for _ in range(inf + 1)] for _ in range(N + 1)]


for city_index in range(1,N+1):
    for total_cost in range(1,inf + 1):

        cost = promotion_cost[city_index]
        client = promoted_client[city_index]

        if total_cost - cost >= 0:
            dp[city_index][total_cost] = max(dp[city_index - 1][total_cost], dp[city_index ][total_cost - cost] + client)

        else:
            dp[city_index][total_cost] = dp[city_index - 1][total_cost]

        if dp[city_index][total_cost] >= C:
            break

for i in range(inf+1):
    for j in range(N+1):
        if dp[j][i] >= C:
            print(i)
            exit(0)
