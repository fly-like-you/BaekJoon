import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }


        for (int i = N - 1; i >= 0; i--) {
            int cur = arr[i];
            for (int j = i; j < N; j++) {
                if (cur > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + cur);

                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}