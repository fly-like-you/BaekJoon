import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, R;
    static double maxSize = -1;
    static int[] piles;
    static int[] flags;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) * 2;

        piles = new int[N];
        flags = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            piles[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            flags[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(flags);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int base = Math.abs(piles[i] - piles[j]);
                if (base == 0) continue;
                
                double target = (double) R / base;
                int lb = customBound(target);
                if (lb >= 0) {
                    maxSize = Math.max(flags[lb] * base / 2.0, maxSize);
                }
            }
        }
        if (maxSize == -1) {
            System.out.println(-1);
        } else {
            System.out.printf("%.1f\n", maxSize);
        }
    }

    private static int customBound(double target) {
        int start = 0;
        int end = M - 1;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (flags[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;  // end가 target 이하의 값 중 최대 값의 인덱스를 가리킵니다.
    }
}