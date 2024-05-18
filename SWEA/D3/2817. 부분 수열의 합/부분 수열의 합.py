from itertools import combinations
T = int(input())


def solution(idx, n, k, N):
    cnt = 0
    if n == K:
        return 1
    elif n > K or idx >= N:
        return 0

    cnt += solution(idx + 1, nums[idx] + n, k, N)
    cnt += solution(idx + 1,  n, k, N)

    return cnt




for t in range(1, T+1):
    matrix = []
    N, K = map(int, input().split())
    nums = list(map(int, input().split()))
    print(f'#{t} {solution(0, 0, K, N)}')
