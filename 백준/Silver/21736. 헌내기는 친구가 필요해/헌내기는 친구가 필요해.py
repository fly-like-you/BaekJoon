from sys import stdin
from collections import deque
read = stdin.readline
N, M = map(int, input().split())

# 목표는 내 실행 속도보다 빠른 코드 만들기!

campus_map = []
find_p = deque()
visit = [[0] * M for _ in range(N)]

for _ in range(N):
    line = read().rstrip()
    for __ in range(M):
        if line[__] == 'I':
            visit[_][__] = 1
            find_p.append((_, __))
    campus_map.append(line)


dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

answer = 0

while find_p:
    coord = find_p.popleft()
    for i in range(4):
        nx = coord[0] + dx[i]
        ny = coord[1] + dy[i]
        if not (0 <= nx < N and 0 <= ny < M):
            continue
        if visit[nx][ny]:
            continue

        if campus_map[nx][ny] == 'P':
            answer += 1
            find_p.append([nx, ny])
            visit[nx][ny] = -1

        elif campus_map[nx][ny] == 'O':
            find_p.append([nx, ny])
            visit[nx][ny] = -1




print(answer) if answer > 0 else print("TT")