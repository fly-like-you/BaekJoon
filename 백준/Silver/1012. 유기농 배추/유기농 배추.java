import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int count;
    static int[][] cabbage;
    static boolean[][] visit;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static void bfs(int x, int y) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];

            visit[x][y] = true;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visit[nx][ny] && cabbage[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int c = 0; c < T; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            cabbage = new int[M][N];
            visit = new boolean[M][N];

            K = Integer.parseInt(st.nextToken());

            // 배추의 위치
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());

                  cabbage[p1][p2] = 1;
            }
            count = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] == 1 && !visit[x][y]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
