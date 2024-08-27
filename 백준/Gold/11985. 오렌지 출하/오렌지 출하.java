import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
6 3 6
1
2
3
1
2
1
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K;
    static int[] oranges;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        oranges = new int[N + 1];
        dp = new long[N + 1];
        for (int i = 0; i < N; i++) {
            oranges[i+1] = Integer.parseInt(br.readLine());
            dp[i+1] = Long.MAX_VALUE;
        }
        oranges[0] = 0;
        dp[0] = 0;


        for (int i = 1; i <= N; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= M; j++) {
                // 오렌지의 박스의 크기
                if (i < j) break; // 박스크기가 오렌지 갯수보다 많아질 수 없다.
                // 상자 속에서 최대, 최소값인 오렌지의 크기를 찾기
                max = Math.max(max, oranges[i - j + 1]);
                min = Math.min(min, oranges[i - j + 1]);
                long cost = K + (long) j * (max - min);
                dp[i] = Math.min(dp[i], dp[i - j] + cost);
            }
        }
        System.out.println(dp[N]);
    }
}