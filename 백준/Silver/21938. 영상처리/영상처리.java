import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int T;
    static int[][] display;
    static boolean[][] visited;
    static int answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        display = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int pixel = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
                display[i][j] = pixel;
            }
        }
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (display[i][j] / 3 >= T && !visited[i][j]) {
                    visited[i][j] = true;
                    answer++;
                    bfs(new Point(i, j));
                }

            }
        }

        System.out.println(answer);

    }
    private static void bfs(Point point) {

        Queue<Point> q = new ArrayDeque<>();
        q.offer(point);

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                if (display[nx][ny] / 3 < T) continue;

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }

    }
    static class Point {
        int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}