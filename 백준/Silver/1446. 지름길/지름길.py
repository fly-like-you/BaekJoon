N, d = map(int, input().split())
shortcuts = []
for i in range(N):
    shortcut = list(map(int, input().split()))
    if shortcut[1] <= d:
        shortcuts.append(shortcut)

shortcuts.sort()
dp = {}
dp[0] = 0
dp[d] = d
shortcuts_length = len(shortcuts)
for i in range(shortcuts_length):
    start = shortcuts[i][0]
    end = shortcuts[i][1]
    dp.setdefault(start, start)
    dp.setdefault(end, end)

k = 0
prev = 0
for key in sorted(dp.keys()):
    dp[key] = min(dp[key], dp[prev] + (key - prev))
    while k < shortcuts_length:
        start = shortcuts[k][0]
        end = shortcuts[k][1]
        dist = shortcuts[k][2]
        if key == start:
            k += 1
            dp[end] = min(dp[start] + dist, dp[end])
        else:
            break
    prev = key




print(dp[d])
