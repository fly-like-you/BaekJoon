from collections import deque

N, M = map(int, input().split())

board = [i for i in range(101)]
visited = [0 for _ in range(101)]
ladder = [[], []]
snakes = [[], []]

for _ in range(N):
    x, y = map(int, input().split())
    ladder[0].append(x)
    ladder[1].append(y)
for _ in range(M):
    u, v = map(int, input().split())
    snakes[0].append(u)
    snakes[1].append(v)

def bfs(start):
    queue = deque([start])

    while queue:
        x = queue.popleft()
        for i in range(1, 7):
            nx = x + i
            if nx > 100:
                continue

            for l in range(len(ladder[0])):
                if nx == ladder[0][l]:  # 주사위를 굴려서 사다리의 시작점에 위치해있으면
                    nx = ladder[1][l]

            for s in range(len(snakes[0])):
                if nx == snakes[0][s]:
                    nx = snakes[1][s]

            if not visited[nx]:
                queue.append(nx)
                visited[nx] = visited[x] + 1



bfs(1)
print(visited[100])