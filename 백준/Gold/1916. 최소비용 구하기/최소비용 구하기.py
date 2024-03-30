# N개의 도시, M개의 버스(간선)
# A 도시에서 B 도시까지 가는데 드는 버스 비용의 최소화

# 도시의 개수, 버스의 개수, 버스의 정보 (출발 도시 번호, 도착 도시 번호, 비용)
# 구하고자 하는 구간 출발점의 도시 번호
import heapq
import sys

input = sys.stdin.readline
N = int(input())
M = int(input())

edges = [[] for _ in range(N + 1)]
costs = [int(1e9)] * (N + 1)

for _ in range(M):
    start, end, cost = map(int, input().split())
    edges[start].append([cost, end])

department, destination = map(int, input().split())
costs[department] = 0

def dijkstra(dist, adj, depart):
    heap = []
    heapq.heappush(heap, [costs[depart], depart])

    while heap:
        cost, node = heapq.heappop(heap)

        if cost > dist[node]:
            continue

        for c, n in adj[node]:
            if c + cost < dist[n]:
                dist[n] = c + cost
                heapq.heappush(heap, [c + cost, n])

dijkstra(costs, edges, department)
print(costs[destination])