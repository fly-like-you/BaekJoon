import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int minPrice = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(1, 0, 0);
        System.out.println(minPrice);
    }

    private static void solution(int x, int sum, int count) {
        if (count == 3) {
            minPrice = Math.min(sum, minPrice);
        } else {
            for (int i = x; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (visited[i][j] || !check(i, j)) continue;

                    // 주변 꽃잎들을 true로 변경
                    int cost = blooming(i, j, true) + sum;
                    // 코스트 계산
                    // 재귀 탐색
                    solution(i, cost, count+1);
                    // 다시 원상복귀
                    blooming(i, j, false);
                }
            }
        }
    }

    private static int blooming(int x, int y, boolean flag) {
        int cost = 0;
        visited[x][y] = flag;
        cost += map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            visited[nx][ny] = flag;
            cost += map[nx][ny];
        }
        return cost;
    }

    private static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }

}