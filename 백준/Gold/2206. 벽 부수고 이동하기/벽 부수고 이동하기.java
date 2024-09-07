import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 메모리: 94,000 KB
 * 시 간: 660 ms
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static char[][] map;
    static int minLength = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = 1;

        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }

        System.out.println(bfs());
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static int bfs() {
        int minPath = 1;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[K+1][N][M];
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            minPath++;
            while(size-- > 0) {
                int[] n = q.poll();
                int k = n[0], x = n[1], y = n[2];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (nx == N-1 && ny == M-1) return minPath;

                    if (map[nx][ny] == '1') {
                        if (k < K && !visited[k+1][nx][ny]) {
                            visited[k+1][nx][ny] = true;
                            q.offer(new int []{k+1, nx, ny});
                        }
                    } else {
                        if (!visited[k][nx][ny]) {
                            visited[k][nx][ny] = true;
                            q.offer(new int []{k, nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
/*
6 4 1
0100
1110
1000
0000
0111
0000
* */