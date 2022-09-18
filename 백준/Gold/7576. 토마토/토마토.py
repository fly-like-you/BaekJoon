from collections import deque
M, N = map(int, input().split())
maze = []
for _ in range(N):
    temp = list(map(int, input().split()))
    maze.append(temp)

res = 0

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
queue = deque()
def bfs():

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if maze[nx][ny] == 0:
                maze[nx][ny] = maze[x][y] + 1
                queue.append([nx,ny])

for x in range(N):
    for y in range(M):
        if maze[x][y] == 1:
            queue.append([x,y])
bfs()
for i in maze:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    res = max(res, max(i))
print(res - 1)
