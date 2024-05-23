import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static boolean[] visited;
    static int[][] graph;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = graph[e][s] = 1;
        }

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(sb);
        sb = new StringBuilder();
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }


    static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        for (int i = 1; i < N + 1; i++) {
            if (graph[start][i] == 1 && visited[i] != true) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node + " ");

            for (int i = 1; i < N + 1; i++) {
                if (graph[node][i] == 1 && visited[i] != true) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
