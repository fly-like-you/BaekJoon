import sys
input = sys.stdin.readline
N, r, c = map(int, input().split())



def recursive(N, r, c):
    length = 2 ** (N - 1)
    block_size = (2 ** N) * (2 ** N) // 4
    if r < length and c < length:  # 1사분면
        return 0
    if r < length and c >= length:  # 2사분면
        return block_size * 1
    if r >= length and c < length:  # 3사분면
        return block_size * 2
    if r >= length and c >= length:  # 4사분면
        return block_size * 3


ans = 0
while True:
    if N < 1:
        break
    ans += recursive(N, r, c)
    length = 2 ** (N - 1)
    if length <= r:
        r -= length
    if length <= c:
        c -= length
    N -= 1

print(ans)
