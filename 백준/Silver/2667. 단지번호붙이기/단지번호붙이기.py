from collections import deque
N = int(input())
maze = []
for _ in range(N):
    temp = list(map(int, input()))
    maze.append(temp)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
temp = []
def bfs(a,b):
    queue = deque()
    queue.append([a,b])
    maze[a][b] = 0
    count = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if maze[nx][ny] == 0:
                continue
            if maze[nx][ny] == 1:
                maze[nx][ny] = 2
                count += 1
                queue.append([nx,ny])
    return count

for x in range(N):
    for y in range(N):
        if maze[x][y] == 1:
            temp.append(bfs(x,y))

print(len(temp))
temp.sort()
for i in temp:
    print(i)