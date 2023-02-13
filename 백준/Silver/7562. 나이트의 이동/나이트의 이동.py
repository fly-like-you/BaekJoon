from collections import deque
T = int(input())

for _ in range(T):
    I = int(input())
    chess = [[0 for _ in range(I)] for _ in range(I)]
    visited = [[False for _ in range(I)] for _ in range(I)]

    initial_pos = list(map(int, input().split()))
    arrive_pos = list(map(int, input().split()))

    knight_movable_pos_x = [1, 1, 2, 2, -1, -1, -2, -2]
    knight_movable_pos_y = [2, -2, 1, -1, 2, -2, 1, -1]
    def bfs(graph, start):
        queue = deque([start])
        visited[start[0]][start[1]] = True
        while queue:
            temp = queue.popleft()
            node_x, node_y = temp[0], temp[1]
            for i in range(8):
                x = knight_movable_pos_x[i] + node_x
                y = knight_movable_pos_y[i] + node_y
                if x >= I or x < 0 or y >= I or y < 0:
                    continue

                if not visited[x][y]:
                    visited[x][y] = True
                    graph[x][y] = graph[node_x][node_y] + 1
                    queue.append([x,y])

    bfs(chess, initial_pos)
    print(chess[arrive_pos[0]][arrive_pos[1]])