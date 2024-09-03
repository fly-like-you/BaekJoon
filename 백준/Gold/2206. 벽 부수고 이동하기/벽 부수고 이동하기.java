import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 */
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] map;

    static class Node {
        int x, y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = str.charAt(j) - '0';
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N + 1][M + 1][2];

        q.offer(new Node(1, 1, 0));
        visited[1][1][0] = true;

        int distance = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();
                int x = cur.x;
                int y = cur.y;
                int cnt = cur.cnt;

                if (x == N && y == M) {
                    System.out.println(distance);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 1 || nx > N || ny < 1 || ny > M) continue;

                    if (map[nx][ny] == 1) {
                        if (cnt == 1) continue;
                        if (visited[nx][ny][1]) continue;

                        q.offer(new Node(nx, ny, cnt + 1));
                        visited[nx][ny][cnt+1] = true;
                    } else {
                        if (visited[nx][ny][cnt]) continue;

                        q.offer(new Node(nx, ny, cnt));
                        visited[nx][ny][cnt] = true;
                    }
                }
            }
            distance++;
        }
        System.out.println(-1);
    }
}