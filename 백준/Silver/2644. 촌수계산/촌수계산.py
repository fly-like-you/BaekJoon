from collections import deque

N = int(input())

A,B = map(int, input().split())
M = int(input())

graph = [ [] for i in range(N+1) ]

# 그래프 준비
for _ in range(M):
    x,y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [False for i in range(N+1)]
res = [0 for i in range(N+1)]
def bfs(x):
    queue = deque()
    queue.append(x)
    visited[x] = True
    while queue:
        a = queue.popleft()
        for i in graph[a]:
            if not visited[i]:
                queue.append(i)
                res[i] = res[a] + 1
                visited[i] = True
bfs(A)

if res[B] > 0:
    print(res[B])
else:
    print(-1)