from collections import deque

def bfs(graph, start, visited):
    q = deque([(start, 0)])
    while q:
        node, color = q.popleft()
        visited[node] = color
        for neighbor in graph[node]:
            if visited[neighbor] == -1:
                q.append((neighbor, color ^ 1))
            elif visited[neighbor] == visited[node]:
                return False
    return True

def is_bipartite(graph):
    n = len(graph)
    visited = [-1] * n
    for i in range(n):
        if visited[i] == -1 and not bfs(graph, i, visited):
            return False
    return True

t = int(input())
for _ in range(t):
    v, e = map(int, input().split())
    graph = [[] for _ in range(v)]
    for _ in range(e):
        u, v = map(int, input().split())
        graph[u-1].append(v-1)
        graph[v-1].append(u-1)
    if is_bipartite(graph):
        print("YES")
    else:
        print("NO")
