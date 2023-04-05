N, M = map(int, input().split())

half = N // 2
if half < M:
    M = N - M

def facto(n, r):
    ret = 1
    end_point = n-r
    while True:
        ret *= n
        n -= 1

        if n == end_point:
            break

    return ret

up = facto(N, M)
down = facto(M, M - 1)

print(up//down)
