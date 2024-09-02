import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int V, E;
    static List<Node>[] adjList;
    static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new List[V + 1];
        for (int i = 1; i <= V; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, weight));
            adjList[to].add(new Node(from, weight));
        }
        System.out.println(getMSTCost());
    }
    static class Vertex {
        int no;
        int weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }

    private static long getMSTCost() {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Vertex(1, 0));

        int[] minEdge = new int[V + 1];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;
        long result = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            // 1. 주변 간선 중 가중치가 최소가 되는 정점을 선택하기
            Vertex cur = pq.poll();
            if (visited[cur.no]) continue;

            visited[cur.no] = true;
            result += cur.weight;
            if (++cnt == V) break;

            for (Node n : adjList[cur.no]) {
                if (visited[n.to]) continue;
                // 내 인접 노드들에 대해서 minEdge의 값보다 작은경우에만 offer
                if (minEdge[n.to] > n.weight)
                pq.offer(new Vertex(n.to, n.weight));
            }
        }
        return result;
    }


}