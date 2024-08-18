import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T, D, W, K;
    static int minInject;
    static char[][] film;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ").append(solution()).append("\n");
        }
        System.out.println(sb);
    }

    public static int solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        minInject = Integer.MAX_VALUE;
        film = new char[D][W];

        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                film[i][j] = st.nextToken().charAt(0);
            }
        }

        subset(0, 0);
        return minInject;
    }

    public static void subset(int depth,  int injectCnt) {
        if (injectCnt > minInject) {
            return;
        }
        if (depth == D) {
            if (filmTest()) {
                minInject = Math.min(injectCnt, minInject);
            }
            return;
        }

        subset(depth+1, injectCnt);

        char[] copy = film[depth].clone();
        Arrays.fill(film[depth], Character.forDigit(0, 10));
        subset(depth+1, injectCnt+1);

        Arrays.fill(film[depth], Character.forDigit(1, 10));
        subset(depth+1, injectCnt+1);

        film[depth] = copy;

    }
    public static boolean filmTest() {
        for (int i = 0; i < W; i++) {
            if (!unitTest(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean unitTest(int i) {
        for (int j = 0; j <= D - K; j++) {
            int flag = 0;

            for (int k = j; k < j + K - 1; k++) {
                if (film[k][i] == film[k+1][i]) {
                    flag++;
                }
            }
            if (flag == K - 1) {
                return true;
            }
        }
        return false;
    }


}
