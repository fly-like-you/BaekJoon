from collections import deque
import sys
N = int(sys.stdin.readline())
graph = []

graph = [list(map(int, input())) for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
def bfs(n, x0, y0):  # 가로 세로 n칸 만큼 bfs x,y는 왼쪽 위 첫번째 좌표

    if n == 1:
        print(graph[x0][y0], end='')
        return graph[x0][y0]
    visited = [[False for _ in range(n)] for _ in range(n)]
    visited[0][0] = True
    queue = deque([[x0, y0]])
    while queue:
        node = queue.popleft()
        for i in range(4):
            x, y = node[0], node[1]
            nx = x + dx[i]
            ny = y + dy[i]
            if ny >= y0 + n or ny < y0 or nx >= x0 + n or nx < x0:
                continue
            if not visited[nx-x0][ny-y0]:
                if graph[nx][ny] != graph[x][y]:
                    print("(", end='')
                    bfs(n//2, x0, y0)
                    bfs(n//2, x0, y0+(n//2))
                    bfs(n // 2, x0 + (n // 2), y0)
                    bfs(n // 2, x0 + (n // 2), y0 + (n // 2))
                    print(")", end='')
                    return
                else:
                    queue.append([nx,ny])
                    visited[nx-x0][ny-y0] = True
    print(graph[x0][y0],end='')


bfs(N,0,0)