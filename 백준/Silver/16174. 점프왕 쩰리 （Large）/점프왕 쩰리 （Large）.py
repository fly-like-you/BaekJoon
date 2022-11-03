from collections import deque
# N = 3
# board = [
#     [1,1,10],
#     [1,5,1],
#     [2,2,-1]
# ]
board = []
N = int(input())
for _ in range(N):
    temp = list(map(int, input().split()))
    board.append(temp)
visited = [[False for i in range(N)] for i in range(N)]
queue = deque()
queue.append([0, 0])
visited[0][0] = True
dx = [1, 0]
dy = [0, 1]
def bfs():
    while queue:
        x, y = queue.popleft()
        if board[x][y] == -1:
            print("HaruHaru")
            exit(0)
        value = board[x][y]
        for i in range(2):
            nx = x + dx[i] * value
            ny = y + dy[i] * value
            if nx >= N or ny >= N or nx < 0 or ny < 0:
                continue
            if not visited[nx][ny]:
                queue.append([nx, ny])
                visited[nx][ny] = True

bfs()
print("Hing")