import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[41];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 41; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        for (int i = 0; i < N; i++) {

            int fibo = Integer.parseInt(br.readLine());
            if (fibo == 0) {
                System.out.println("1 0");
            } else {
                System.out.println(dp[fibo-1] + " " + dp[fibo]);
            }
        }
    }

}
