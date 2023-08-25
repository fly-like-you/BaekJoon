from collections import deque
import sys
input = sys.stdin.readline
N, W, L = map(int, input().split())
trucks = list(map(int, input().split()))

# N, W, L = 4, 2, 10
# trucks = deque([1, 1, 1, 1])

bridge = [0] * W
weight, time = 0, 0

while bridge:
    time += 1

    out = bridge.pop(0)
    weight -= out

    if trucks:
        if weight + trucks[0] <= L:
            weight += trucks[0]
            bridge.append(trucks.pop(0))
        else:
            bridge.append(0)

print(time)

