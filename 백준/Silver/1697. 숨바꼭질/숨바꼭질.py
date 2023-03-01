from collections import deque

N, M = map(int, input().split())


# bfs로 탐색한다.
def bfs(start):
    queue = deque([start])

    while queue:
        node = queue.popleft()
        if node == M:
            print(visited[node])
            break
        for nx in (node-1, node+1, node*2):

            if 0 <= nx <= MAX and not visited[nx]:
                visited[nx] = visited[node] + 1
                queue.append(nx)

MAX = 10 ** 5
visited = [0] * (MAX + 1)

bfs(N)