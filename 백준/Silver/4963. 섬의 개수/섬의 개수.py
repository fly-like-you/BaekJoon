from collections import deque

# W, H = 5, 4
# chart = [[1, 0, 1, 0, 0],
#          [1, 0, 0, 0, 0],
#          [1, 0, 1, 0, 1],
#          [1, 0, 0, 1, 0]]
while True:
    W, H = map(int, input().split())
    if W == 0 and H == 0:
        break
    chart = [list(map(int, input().split())) for _ in range(H)]

    movable_pos_x = [1, 1, -1, -1, 1, -1, 0, 0]
    movable_pos_y = [1, -1, 1, -1, 0, 0, 1, -1]


    def bfs(pos_x, pos_y):
        queue = deque([[pos_x, pos_y]])
        chart[pos_x][pos_y] = 0
        while queue:
            now_pos = queue.popleft()
            now_x, now_y = now_pos[0], now_pos[1]
            for i in range(8):
                x = movable_pos_x[i] + now_x
                y = movable_pos_y[i] + now_y
                if x >= H or x < 0 or y >= W or y < 0:
                    continue
                if chart[x][y] == 1:
                    chart[x][y] = 0
                    queue.append([x, y])


    count = 0
    for i in range(H):
        for j in range(W):
            if chart[i][j] == 1:
                bfs(i, j)
                count += 1

    print(count)
