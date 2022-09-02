from collections import deque
count = 0
def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    global count
    count += 1

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)



N = int(input())
M = int(input())

visited = [False] * (N+1)
graph2 = [[] for i in range(N+1)]

for _ in range(M):
    a,b=map(int,input().split())
    graph2[a].append(b)
    graph2[b].append(a)

dfs(graph2, 1, visited)
print(count -1)