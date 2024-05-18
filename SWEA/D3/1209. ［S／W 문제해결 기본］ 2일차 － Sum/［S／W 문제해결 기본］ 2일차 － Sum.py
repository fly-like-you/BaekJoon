T = 10
N = 100

def solution():
    max_val = 0
    for i in matrix:
        max_val = max(max_val, sum(i))

    for i in rot_matrix:
        max_val = max(max_val, sum(i))

    sum_val = 0
    for i in range(N):
        sum_val += matrix[i][i]
    max_val = max(max_val, sum_val)

    sum_val = 0
    for i in range(N):
        sum_val += matrix[i][N - i - 1]

    max_val = max(max_val, sum_val)

    return max_val

for t in range(1, T+1):
    _ = int(input())
    matrix = []
    for _ in range(N):
        matrix.append(list(map(int, input().split())))

    rot_matrix = list(map(list, zip(*matrix)))
    print(f'#{t} {solution()}')
