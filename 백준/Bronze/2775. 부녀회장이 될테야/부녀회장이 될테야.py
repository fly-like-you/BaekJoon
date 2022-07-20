testCase = int(input()) # 테스트 케이스 입력

for _ in range(testCase):
    k = int(input()) # k층
    n = int(input()) # n호

    hotel = [[0 for col in range(n)] for row in range(k+1)]
    for i in range(1,n+1):
        hotel[0][i-1] = i
    for a in range(1,k+1):
        for b in range(n):
            for c in range(0,b+1):
                hotel[a][b] += hotel[a-1][c]
    print(hotel[k][n-1])