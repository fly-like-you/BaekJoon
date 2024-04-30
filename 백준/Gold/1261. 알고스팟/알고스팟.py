import sys
from collections import deque
input = sys.stdin.readline
# 6 6
# 001111
# 010000
# 001111
# 110001
# 011010
# 100010

N, M = map(int, input().split())
matrix = []
dx = (1, -1, 0, 0)
dy = (0, 0, 1, -1)
for i in range(M):
    line = list(map(int, input()[:-1]))
    matrix.append(line)

def bfs():
    visited = [[float('inf') for _ in range(N)] for _ in range(M)]
    visited[0][0] = 0

    queue = deque([[0, 0]])
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= M or ny < 0 or ny >= N:
                continue

            if visited[nx][ny] > visited[x][y] + matrix[nx][ny]:
                visited[nx][ny] = visited[x][y] + matrix[nx][ny]
                queue.append([nx, ny])
    return visited
print(bfs()[M-1][N-1])




