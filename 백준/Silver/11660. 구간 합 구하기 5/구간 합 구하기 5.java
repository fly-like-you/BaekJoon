import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] matrix;
    static StringTokenizer st;
    static BufferedReader br;
    static int answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {

                } else if (j == 0) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
                } else if (i == 0) {
                    matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
                } else {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;
            if (x1 == 0 && y1 == 0) {
                sum += matrix[x2][y2];
            } else if (x1 == 0) {
                sum += matrix[x2][y2] - matrix[x2][y1 - 1];
            } else if (y1 == 0) {
                sum += matrix[x2][y2] - matrix[x1 - 1][y2];
            } else {
                sum += matrix[x2][y2] - matrix[x2][y1 - 1] - matrix[x1 - 1][y2] + matrix[x1 - 1][y1 - 1];
            }
            sb.append(sum + "\n");

        }
        System.out.println(sb);

    }


}