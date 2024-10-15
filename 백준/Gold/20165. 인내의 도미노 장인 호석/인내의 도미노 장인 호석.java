import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, R, score;
    static int[][] arr;
    static boolean[][] status;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        status = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int n, m;
        int dir;
        for (int i = 0; i < R; i++) {
            // 공격수 행동
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()) - 1;
            m = Integer.parseInt(st.nextToken()) - 1;
            dir = mapping(st.nextToken().charAt(0));
            attack(n, m, dir);

            // 수비수 행동
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()) - 1;
            m = Integer.parseInt(st.nextToken()) - 1;
            defense(n, m);
        }

        StringBuilder sb = new StringBuilder();
        // False -> 안넘어짐
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (status[i][j]){
                    sb.append("F ");

                } else {
                    sb.append("S ");

                }
            }
            sb.append("\n");
        }
        System.out.println(score);
        System.out.println(sb);
    }
    private static void attack(int n, int m, int dir) {
        int power = arr[n][m] - 1;
        status[n][m] = true;
        int nx, ny;
        score++;
        while (power > 0) {
            nx = n + dx[dir];
            ny = m + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;

            if (!status[nx][ny]) {
                score++;
                power = Math.max(power, arr[nx][ny]);
            }
            status[nx][ny] = true;
            power--;
            n = nx; m = ny;
        }
    }

    private static void defense(int n, int m) {
        status[n][m] = false;
    }

    private static int mapping(char dir) {
        switch (dir) {
            case 'E':
                return 0;
            case 'W':
                return 1;
            case 'S':
                return 2;
            case 'N':
                return 3;
        }
        return -1;
    }

}