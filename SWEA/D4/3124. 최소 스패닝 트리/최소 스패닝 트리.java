
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, V, E;
    static Node[] adjList;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjList = new Node[V + 1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adjList[u] = new Node(v, w, adjList[u]);
                adjList[v] = new Node(u, w, adjList[v]);
            }


            sb.append("#").append(t).append(" ").append(PRIM()).append("\n");
        }
        System.out.println(sb);
    }

    static long PRIM() {
        // 트리의 주변 정점들을 검사하여
        // 가중치가 가장 낮은 정점을 찾고
        // 해당 정점을 이어붙인다
        // 정점을 붙이고 해당 정점으로부터 인접한 정점들간의 가중치를 검사해서 가중치 배열을 업데이트
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Vertex(1, 0));

        long result = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            if (visited[cur.no]) continue;

            visited[cur.no] = true;
            result += cur.w;

            cnt++;
            if (cnt == V) break;

            for (Node n = adjList[cur.no]; n != null; n = n.next) {
                if (visited[n.to]) continue;
                pq.offer(new Vertex(n.to, n.w));
            }
        }
        return result;
    }

    static class Node{
        int to, w;
        Node next;

        public Node(int to, int w, Node next) {
            this.to = to;
            this.w = w;
            this.next = next;
        }
    }

    static class Vertex{
        int no;
        int w;
        public Vertex(int no, int w) {
            this.no = no;
            this.w = w;
        }

    }
}
