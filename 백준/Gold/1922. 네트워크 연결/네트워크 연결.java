import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    /*
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
    */
    public static void main(String[] args) throws IOException {

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

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

    private static long getMSTCost() {
        boolean[] visited = new boolean[V + 1];
        long result = 0;
        int[] minEdges = new int[V + 1];
        Arrays.fill(minEdges, Integer.MAX_VALUE);
        minEdges[1] = 0;

        for (int i = 1; i <= V; i++) {
            // 현재 트리에 포함되지 않은 정점 중에서 최소 간선 가중치를 가진 정점을 선택
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && minEdges[j] < min) {
                    min = minEdges[j];
                    minVertex = j;
                }
            }

            if (minVertex == -1) { // 모든 정점을 다 방문하지 않았는데 더 이상 연결할 간선이 없는 경우
                return -1;
            }

            visited[minVertex] = true;
            result += min;

            // 선택된 정점의 인접 정점들의 최소 간선 비용을 업데이트
            for (Node n : adjList[minVertex]) {
                if (!visited[n.to] && minEdges[n.to] > n.weight) {
                    minEdges[n.to] = n.weight;
                }
            }
        }

        return result;
    }



}