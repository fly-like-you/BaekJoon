height, weight = map(int, input().split())
matrixA = []
matrixB = []
matrixC = []
for i in range(height):

    temp = list(map(int, input().split()))
    matrixA.append(temp)
for i in range(height):

    temp = list(map(int, input().split()))
    matrixB.append(temp)
for i in range(height):
    for j in range(weight):
        print(matrixA[i][j] + matrixB[i][j], end=' ')
    print()