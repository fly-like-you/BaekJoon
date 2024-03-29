n, d = map(int, input().split())
shortcut = []
for i in range(n): shortcut.append(list(map(int, input().split())))
shortcut.sort()
dp = [i for i in range(d + 1)]

k = 0

for i in range(d + 1):
    dp[i] = min(dp[i-1] + 1, dp[i])

    while k < n:
        start = shortcut[k][0]
        end = shortcut[k][1]
        dist = shortcut[k][2]
        if i == start:
            k += 1
            if end <= d:
                dp[end] = min(dp[start] + dist, dp[end])
        else:
            break

print(dp[d])
