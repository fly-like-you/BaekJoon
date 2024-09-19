

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N;
    static int[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                int u = Integer.parseInt(br.readLine())-1;
                graph[i] = u;
            }
            System.out.println(bfs());

        }

    }

    private static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 1;
        visited[0] = true;
        q.offer(graph[0]);

        while (!q.isEmpty()) {
            Integer v = q.poll();

            if (visited[v]) continue;
            if (v == N - 1) return cnt;
            visited[v] = true;
            q.offer(graph[v]);
            cnt++;
        }

        return 0;
    }

}

/*
1
7
2
3
4
5
6
7
1
 */
