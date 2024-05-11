from collections import deque
dx, dy, dz = (1, -1, 0, 0, 0, 0), (0, 0, 1, -1, 0, 0), (0, 0, 0, 0, 1, -1)
M, N, H = map(int, input().split())

box = []
visited = [[[0 for i in range(M)] for _ in range(N)] for _ in range(H)]

for _ in range(H):
    l_2 = []
    for _ in range(N):
        l_1 = list(map(int, input().split()))
        l_2.append(l_1)
    box.append(l_2)

tomatos = []
for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k] == 1:
                tomatos.append((i, j, k))

def bfs(pos):
    queue = deque(pos)
    for i, j, k in pos:
        visited[i][j][k] = 1
    while queue:
        z, x, y = queue.popleft()
        for i in range(6):
            nx, ny, nz = x + dx[i], y + dy[i], z + dz[i]

            if 0 > nx or nx >= N or 0 > ny or ny >= M or 0 > nz or nz >= H:
                continue

            if visited[nz][nx][ny] == 0 and box[nz][nx][ny] != -1:
                queue.append((nz, nx, ny))
                visited[nz][nx][ny] = visited[z][x][y] + 1



bfs(tomatos)
max_val = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            days = visited[i][j][k]
            tomato = box[i][j][k]
            if tomato != -1 and days == 0:
                print(-1)
                exit()

            max_val = max(max_val, visited[i][j][k])
print(max_val - 1)