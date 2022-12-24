import sys
while True:
    N, K = map(int, sys.stdin.readline().split())
    bunza = 1
    bunmo = 1
    if N == 0: break

    up = min(K, N-K)
    for i in range(up):

        bunza *= N - i
        bunmo *= up - i


    print(bunza // bunmo)



