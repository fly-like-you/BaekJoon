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
        // 두 말뚝을 결정하기
        // 말뚝에 대해서 현수막을 직접 걸어보기
        // 말뚝 수 : 2,000, 깃대의 수: 40,000
        // 완탐: 2,000 C 2 * 40,000
        // 2개 고르고 나머지 이분탐색
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
            System.out.printf("%.1f", maxSize);

        }
    }

    private static int customBound(double target) {
        int start = 0;
        int end = M - 1;
        int maxIdx = -1;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (flags[mid] <= target) {
                start = mid + 1;
                maxIdx = Math.max(maxIdx, mid);
            } else {
                end = mid - 1;
            }
        }

        return maxIdx;
    }

}
/*
3 5 23
-5 0 5
1 6 2 8 10
 */