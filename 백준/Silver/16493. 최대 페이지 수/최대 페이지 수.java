import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] dp;
    static int[][] book;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 남은 기간
        M = Integer.parseInt(st.nextToken()); // 챕터

        book = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            book[i][0] = Integer.parseInt(st.nextToken());
            book[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[M+1][N+1];
        System.out.println(dfs(0, N));

    }

    private static int dfs(int depth, int remain) {
        if (remain < 0) return Integer.MIN_VALUE;
        if (depth == M) {
            return 0;
        }
        if (dp[depth][remain] > 0) return dp[depth][remain];

        int selected = dfs(depth + 1, remain - book[depth][0]) + book[depth][1];
        int unselected = dfs(depth + 1, remain);

        return dp[depth][remain] = Math.max(selected, unselected);
    }
}
/*
5 3
2 100
2 20
2 40
 */