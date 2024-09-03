import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }
        visited[R-1][0] = true;
        dfs(new Integer[]{R - 1, 0}, 1);
        System.out.println(cnt);

    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static void dfs(Integer[] p, int m) {
        int sx = p[0], sy = p[1];
        if (sx == 0 && sy == C - 1) {
            if (m == K) {
                cnt++;
            }
            return;
        }


        for (int i = 0; i < 4; i++) {

            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 'T') continue;

            visited[nx][ny] = true;
            dfs(new Integer[] {nx, ny}, m + 1);
            visited[nx][ny] = false;

        }

    }

}