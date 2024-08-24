import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
3 3
2 5000
1 1000
1 2000
    **/
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N; // 문제수
    static int T; // 남은 제출 기간
    static int[] cost; // 벌금
    static int[] t; // 시간
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        dp = new int[N+1][T+1];
        t = new int[N+1];
        cost = new int[N+1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[i] = c;
            sum += c;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <=T; j++) {
                if (j - t[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-t[i]] + cost[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(sum - dp[N][T]);
    }

}