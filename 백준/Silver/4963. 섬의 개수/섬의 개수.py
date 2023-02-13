from sys import stdin


def bfs(x, y):
    n = [(x, y)]
    while n:
        x, y = n.pop()
        for deltaX, deltaY in delta:
            X = x + deltaX
            Y = y + deltaY
            if 0 <= X < H and 0 <= Y < W and graph[X][Y] == '1':
                graph[X][Y] = '0'
                n.append((X, Y))


read = stdin.readline
delta = [(0, 1), (0, -1), (1, 0), (-1, 0), (-1, -1), (1, -1), (1, 1), (-1, 1)]
while True:
    W, H = map(int, read().split())
    if W == H == 0:
        break
    count = 0
    graph = [list(read().split()) for _ in range(H)]
    for i in range(H):
        for j in range(W):
            if graph[i][j] == '1':
                bfs(i, j)
                count += 1
    print(count)