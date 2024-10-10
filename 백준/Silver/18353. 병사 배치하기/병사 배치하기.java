import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        dp = new int[N];
        Arrays.fill(dp, 1);
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int longest = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && dp[j] > longest) {
                    longest = dp[j];
                }
            }
            dp[i] = longest + 1;
            max = Math.max(dp[i], max);
        }
        System.out.println(N - max);
    }
}
/*
7
15 11 4 8 5 2 4
 */