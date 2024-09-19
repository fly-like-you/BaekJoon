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
    static int[] visited; // boolean -> int로 변경

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N];
            visited = new int[N]; // int 배열로 변경
            for (int i = 0; i < N; i++) {
                int u = Integer.parseInt(br.readLine())-1;
                graph[i] = u;
            }
            Arrays.fill(visited, -1); // 초기값을 -1로 설정
            System.out.println(bfs());
        }

    }

    private static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visited[0] = 0; // 시작점은 0번 이동
        q.offer(0);

        while (!q.isEmpty()) {
            int v = q.poll();

            if (v == N - 1) {
                return visited[v]; // 마지막 노드에 도착하면 그 때의 거리 반환
            }

            int next = graph[v];
            if (visited[next] == -1) { // 아직 방문하지 않은 노드일 때
                visited[next] = visited[v] + 1; // 현재까지의 이동 횟수 + 1
                q.offer(next);
            }
        }

        return 0; // 도착할 수 없는 경우 0 반환
    }
}