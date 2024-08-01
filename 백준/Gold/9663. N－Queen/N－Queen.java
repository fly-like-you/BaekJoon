import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int answer;
    static int[][] chess;
    static int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
    static int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        chess = new int[N][N];
        solution(0, 0);
        System.out.println(answer);
    }

    private static void solution(int x, int depth) {
        if (depth == N) {
            answer++;
        } else {
            for (int j = 0; j < N; j++) {
                if (chess[depth][j] > 0)
                    continue;
                // 둔 곳에 움직일 수 있는 곳에 true 처리
                queen(depth, j, 1);
                solution(j + 1, depth + 1);
                queen(depth, j, -1);
            }
        }
    }


    private static void queen(int x, int y, int flag) {
        chess[x][y] += flag;


        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (true) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    break;

                chess[nx][ny] += flag;
                nx = nx + dx[i];
                ny = ny + dy[i];
            }
        }

    }

}