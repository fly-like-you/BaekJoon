n,d = map(int,input().split())
shortcut = [[] for _ in range(d+1)]
for _ in range(n):
    st,end,w = map(int,input().split())
    if end <= d:
        shortcut[end].append((st,w))
dp = [0] * (d+1)
dp[1] = 1
for i in range(2,d+1):
    if shortcut[i]:
        cost = min([dp[st] + w for st,w in shortcut[i]])
        dp[i] = min(dp[i-1] + 1, cost)
    else:
        dp[i] = dp[i-1] + 1
print(dp[d])