import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
tetris = [[i for i in list(map(int, sys.stdin.readline().rstrip().split()))] for j in range(N)]
def getScore(x,y):
    sumList = []
    sum = tetris[x][y]
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    for i in range(4): # 2번째 좌표 이동
        nx_1 = x + dx[i]
        ny_1 = y + dy[i]
        if(nx_1 >= N or nx_1 < 0 or ny_1 >= M or ny_1 < 0):
            continue
        sum += tetris[nx_1][ny_1]
        for j in range(4): # 3번째 좌표이동
            nx_2 = nx_1 + dx[j]
            ny_2 = ny_1 + dy[j]
            if (nx_2 >= N or nx_2 < 0 or ny_2 >= M or ny_2 < 0 or (nx_2 == x and ny_2 == y)):
                continue
            sum += tetris[nx_2][ny_2]
            for k in range(4): # 4번째 좌표이동
                nx_3 = nx_2 + dx[k]
                ny_3 = ny_2 + dy[k]
                if (nx_3 >= N or nx_3 < 0 or ny_3 >= M or ny_3 < 0):
                    continue
                if(nx_3 == nx_1 and ny_3 == ny_1):
                    continue
                sum += tetris[nx_3][ny_3]
                sumList.append(sum)
                sum -= tetris[nx_3][ny_3]
            for m in range(4):
                nx_4 = nx_1 + dx[m]
                ny_4 = ny_1 + dy[m]
                if (nx_4 >= N or nx_4 < 0 or ny_4 >= M or ny_4 < 0):
                    continue
                if((nx_4 == x and ny_4 == y) or (nx_4 == nx_2 and ny_4 == ny_2)):
                    continue
                sum += tetris[nx_4][ny_4]
                sumList.append(sum)
                sum -= tetris[nx_4][ny_4]
            sum -= tetris[nx_2][ny_2]
        sum -= tetris[nx_1][ny_1]

    return max(sumList)


score = []
for x in range(len(tetris)):
    for y in range(len(tetris[0])):
        score.append(getScore(x,y))


print(max(score))
