# my_code
from collections import deque


def bfs(pos_x, pos_y):
    q = [(pos_x, pos_y)]
    chart[pos_x][pos_y] = '0'
    while q:
        now_x, now_y = q.pop(0)
        for i in range(8):
            x = movable_pos_x[i] + now_x
            y = movable_pos_y[i] + now_y
            if x >= H or x < 0 or y >= W or y < 0:
                continue
            if chart[x][y] == '1':
                chart[x][y] = '0'
                q.append((x, y))
while True:
    W, H = map(int, input().split())
    if W == 0 and H == 0:
        break
    chart = [list(input().split()) for _ in range(H)]

    movable_pos_x = [1, 1, -1, -1, 1, -1, 0, 0]
    movable_pos_y = [1, -1, 1, -1, 0, 0, 1, -1]

    count = 0
    for i in range(H):
        for j in range(W):
            if chart[i][j] == '1':
                bfs(i, j)
                count += 1

    print(count)



#my_code와 #fast_code에서 #fast_code의 실행시간이 빠른 이유를 분석해줘