import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * 시키는대로 구현
 */

//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//1
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, R;
    static int[][] arr;
    static int[] cmds;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        cmds = new int[R];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            cmds[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        print();
    }

    private static void solution() {
        for (int i = 0; i < R; i++) {
            switch (cmds[i]) {
                case 1: operation1(); break;
                case 2: operation2(); break;
                case 3: operation3(); break;
                case 4: operation4(); break;
                case 5: operation5(); break;
                case 6: operation6(); break;
            }
        }
    }

    private static void swap(int[] p1, int[] p2) {
        int temp;
        temp = arr[p1[0]][p1[1]];
        arr[p1[0]][p1[1]] = arr[p2[0]][p2[1]];
        arr[p2[0]][p2[1]] = temp;

    }
    private static void operation1() {
        // 상하 반전
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                swap(new int[]{i, j}, new int[]{N - 1 - i, j});
            }
        }
    }
    private static void operation2() {
        // 좌우 반전
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                swap(new int[]{i, M - 1 - j}, new int[]{i, j});
            }
        }
    }
    private static void operation3() {
        // 시계 방향 회전
        int[][] rotate = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rotate[j][N-1-i] = arr[i][j];
            }
        }
        // swap
        int temp = M;
        M = N;
        N = temp;

        arr = rotate;
    }
    private static void operation4() {
        // 반시계 방향 회전
        int[][] rotate = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rotate[M - 1 - j][i] = arr[i][j];
            }
        }
        // swap
        int temp = M;
        M = N;
        N = temp;

        arr = rotate;
    }
    private static void operation5() {
        // 4개의 그룹을 시계 방향 회전
        // 당겨서 복사하기
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                int n = N / 2;
                int m = M / 2;

                int temp = arr[i][j];
                arr[i][j] = arr[n + i][j];
                arr[n + i][j] = arr[n + i][m + j];
                arr[n + i][m + j] = arr[i][m + j];
                arr[i][m + j] = temp;

            }
        }
    }
    private static void operation6() {
        // 4개의 그룹을 반시계 방향 회전
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                int n = N / 2;
                int m = M / 2;

                int temp = arr[i][j];
                arr[i][j] = arr[i][m + j];
                arr[i][m + j] = arr[n + i][m + j];
                arr[n + i][m + j] = arr[n + i][j];
                arr[n + i][j] = temp;

            }
        }
    }
    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}