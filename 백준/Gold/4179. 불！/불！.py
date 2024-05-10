from collections import deque
import sys

input = sys.stdin.readline

dx = (0, 0, 1, -1)
dy = (1, -1, 0, 0)

def bfs(w, h, pos:list):
    visited = [[float('inf') for _ in range(w)] for _ in range(h)]
    for x, y in pos:
        visited[x][y] = 0
    queue = deque(pos)

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 > nx or h <= nx or 0 > ny or w <= ny:
                continue
            if graph[nx][ny] == '#':
                continue
            if visited[nx][ny] == float('inf'):
                queue.append((nx, ny))
                visited[nx][ny] = visited[x][y] + 1
    return visited

H, W = map(int, input().split())
graph = []
man = []
fires = []
for h in range(H):
    li = list(input())
    for w in range(len(li)):
        if li[w] == 'F':
            fires.append((h, w))
        elif li[w] == 'J':
            man.append((h, w))
    graph.append(li)
man_exit = bfs(W, H, man)
fire_exit = bfs(W, H, fires)

l = []
for i in range(H):
    for j in range(W):
        if i == 0 or j == 0 or i == H-1 or j == W-1:
            if man_exit[i][j] < fire_exit[i][j]:
                l.append(man_exit[i][j])
if l:
    print(min(l) + 1)
else:
    print('IMPOSSIBLE')
