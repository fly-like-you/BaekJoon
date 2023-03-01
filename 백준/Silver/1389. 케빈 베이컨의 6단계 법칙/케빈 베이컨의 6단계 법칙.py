from collections import deque

N, M = map(int, input().split())
graph = [[] for i in range(N+1)]

for i in range(M):
    v1, v2 = map(int, input().split())  # 1, 3

    graph[v1].append(v2)
    graph[v2].append(v1)


def bfs(start):
    queue = deque([start])
    visited[start] += 1
    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if visited[i] == -1:
                queue.append(i)
                visited[i] = visited[node] + 1
    return visited

li = []
for i in range(1, N+1):
    visited = [-1 for i in range(N + 1)]
    li.append(sum(bfs(i)) + 1)

sorted_list = []
for i, v in enumerate(sorted(li)):
    idx = li.index(v)
    sorted_list.append(idx)
print(sorted_list[0]+1)

