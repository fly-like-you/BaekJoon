import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            int sqrt = (int) Math.sqrt(i);
//            if (sqrt * sqrt ==i) {
//                dp[i] = 1;
//            } else {
//            }
            for (int j = 1; j <= sqrt; j++) {

                dp[i] = Math.min(1 + dp[i-j*j], dp[i]);

            }
        }

        System.out.println(dp[N]);
    }
}