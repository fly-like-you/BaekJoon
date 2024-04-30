# 방향 그래프에서 시작점에서 다른 정점으로의 최단 경로 구하기

import heapq
import sys

input = sys.stdin.readline
V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w, v))

def dijkstra(V, start):
    dist = [float('inf')] * (V+1)
    dist[start] = 0
    heap = []
    visited = [False] * (V+1)
    heapq.heappush(heap, (0, start))

    while heap:
        weight, node = heapq.heappop(heap)
        visited[node] = True

        if weight > dist[node]:
            continue

        for w, n in graph[node]:
            cost = dist[node] + w
            if not visited[n] and cost < dist[n]:
                dist[n] = cost
                heapq.heappush(heap, (cost, n))

    return dist


dist = dijkstra(V, K)

for i in range(1, len(dist)):
    print(dist[i] if dist[i] != float('inf') else 'INF')
