import heapq

def dijkstra(adj, dist):
    heap = []
    heapq.heappush(heap, [0, 1])

    while heap:
        weight, node = heapq.heappop(heap)

        if dist[node] < weight:
            continue

        for w, n in adj[node]: # 인접 노드들에 대해서
            if dist[n] > weight + w:
                dist[n] = weight + w
                heapq.heappush(heap, [w + weight, n])




def solution(N, road, K):
    answer = 0
    dist = [float('inf')] * (N + 1)
    dist[1] = 0
    adj = [[] for _ in range(N + 1)]

    for s, e, w in road:
        adj[s].append([w, e])
        adj[e].append([w, s])

    dijkstra(adj, dist)
    return len([i for i in dist if i <= K])

