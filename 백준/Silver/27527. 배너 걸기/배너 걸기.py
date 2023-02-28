import sys
from collections import Counter
import math

input = sys.stdin.readline
N, window_size = map(int, input().split())
arr = list(map(int, input().split()))
count_window = [0 for _ in range(1000001)]

lim = math.ceil(9 * window_size / 10)

for i in range(window_size): # 윈도우 사이즈
    count_window[arr[i]] += 1
    if count_window[arr[i]] >= lim:
        print("YES")
        exit(0)


for i in range(N - window_size):
    count_window[arr[i]] -= 1
    count_window[arr[i + window_size]] += 1
    if count_window[arr[i + window_size]] >= lim:
        print("YES")
        exit(0)

print("NO")
