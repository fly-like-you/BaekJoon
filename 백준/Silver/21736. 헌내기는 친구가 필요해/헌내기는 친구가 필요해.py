# 3 5
# OOOPO
# OIOOX
# OOOXP
# O는 빈 공간, X는 벽, I는 도연이, P는 사람이다.

from collections import deque

N, M = map(int, input().split())

campus_map = [list(input()) for _ in range(N)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(x, y):
    answer = 0

    queue = deque([[x,y]])
    while queue:
        coord = queue.popleft()
        for i in range(4):
            nx = coord[0] + dx[i]
            ny = coord[1] + dy[i]
            if not (0 <= nx < N and 0 <= ny < M):
                continue

            if campus_map[nx][ny] == 'P':
                answer += 1
                queue.append([nx, ny])
                campus_map[nx][ny] = -1

            elif campus_map[nx][ny] == 'O':
                queue.append([nx, ny])
                campus_map[nx][ny] = -1

    return answer

answer = 0
for i in range(N):
    for j in range(M):
        if campus_map[i][j] == 'I':
            campus_map[i][j] = -1
            answer = bfs(i, j)

print(answer) if answer > 0 else print("TT")






