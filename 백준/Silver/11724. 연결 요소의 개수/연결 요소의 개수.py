import sys
from collections import deque
N, M = map(int,sys.stdin.readline().split())
graph = [[] for i in range(N+1)]
for _ in range(M):
    x,y = map(int,sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

count = 0
queue = deque()
visited = [False for _ in range(N+1)]
def bfs(n):
    queue.append(n)
    visited[n] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i] =True
                queue.append(i)
for i in range(1,len(visited)):
    if not visited[i]:
        bfs(i)
        count += 1
print(count)