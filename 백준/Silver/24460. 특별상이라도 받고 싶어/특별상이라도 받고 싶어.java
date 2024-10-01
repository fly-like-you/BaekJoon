import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(N, 0, 0));
    }

    private static int solution(int n, int x, int y) {
        if (n == 2) {
            int[] values = new int[4];
            int idx = 0;
            for (int i = x; i < x + 2; i++) {
                for (int j = y; j < y + 2; j++) {
                    values[idx++] = arr[i][j];
                }
            }
            Arrays.sort(values);
            return values[1];
        } else {
            int[] values = new int[4];
            values[0] = solution(n / 2, x, y);
            values[1] = solution(n / 2, x + n / 2, y);
            values[2] = solution(n / 2, x, y + n / 2);
            values[3] = solution(n / 2, x + n / 2, y + n / 2);

            Arrays.sort(values);
            return values[1];
        }

    }
}

/*
4
15 7 13 5
4 2 1 9
0 10 8 12
3 11 14 6
 */