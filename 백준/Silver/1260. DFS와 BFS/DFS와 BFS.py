from collections import deque
def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=' ')

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        print(v, end = ' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

N, M, V = map(int, input().split())

visited = [False] * (N+1)
graph2 = [[] for i in range(N+1)]

for _ in range(M):
    a,b=map(int,input().split())
    graph2[a].append(b)
    graph2[b].append(a)

for i in range(len(graph2)):
    graph2[i].sort()

dfs(graph2, V, visited)
print()
visited = [False] * (N+1)
bfs(graph2,V,visited)