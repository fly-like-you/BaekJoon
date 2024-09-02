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
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new List[V + 1];
        for (int i = 1; i <= V; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, w));
            adjList[to].add(new Node(from, w));
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
    private static int getMSTCost() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        boolean[] visited = new boolean[V + 1];
        int[] minEdges = new int[V + 1];

        Arrays.fill(minEdges, Integer.MAX_VALUE);
        minEdges[0] = 0;
        pq.offer(new Vertex(1, 0));
        int maxWeight = 0;
        int weight = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            // 정점에서 가장 낮은 가중치의 정점을 가져오기
            Vertex cur = pq.poll();
            if (visited[cur.no]) continue;

            // 해당 정점을 방문처리해주기
            visited[cur.no] = true;
            weight += cur.weight;
            maxWeight = Math.max(maxWeight, cur.weight);

            if (++cnt == V) break;

            // 해당 정점의 간선을 방문하면서 minEdges 업데이트
            for (Node n : adjList[cur.no]) {
                if (!visited[n.to] && minEdges[n.to] > n.weight) {
                    pq.offer(new Vertex(n.to, n.weight));
                    minEdges[n.to] = n.weight;
                }
            }
        }

        return weight - maxWeight;
    }
}