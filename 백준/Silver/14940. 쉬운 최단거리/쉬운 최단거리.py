# 15 15
# 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
# 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
# 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
from collections import deque
dx, dy = (0, 0, 1, -1), (1, -1, 0, 0)
N, M = map(int, input().split()) # 세로, 가로
visited = [[float('inf') for _ in range(M)] for _ in range(N)]

graph = []
target = []
for i in range(N):
    l = list(map(int, input().split()))
    if 2 in l:
        target = [i, l.index(2)]
    graph.append(l)

def bfs(target):
    queue = deque([target])
    visited[target[0]][target[1]] = 0

    while queue:
        x, y, = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 > nx or N <= nx or 0 > ny or M <= ny or graph[nx][ny] == 0:
                continue

            if visited[nx][ny] == float('inf'):
                visited[nx][ny] = visited[x][y] + 1
                queue.append([nx, ny])

    return visited
visited = bfs(target)

for i in range(N):
    for j in range(M):
        k = 0
        if visited[i][j] == float('inf'):
            if graph[i][j] == 0:
                k = 0
            else:
                k = -1
        else:
            k = visited[i][j]
        print(k, end=' ')
    print()
