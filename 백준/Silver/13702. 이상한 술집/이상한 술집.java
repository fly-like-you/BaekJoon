import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static long[] pot;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pot = new long[N];
        long maxVol = 0;
        for (int i = 0; i < N; i++) {
            long v = Long.parseLong(br.readLine());
            pot[i] = v;
            maxVol = Math.max(maxVol, v);
        }

        System.out.println(binarySearch(maxVol));
        // 주어진 막걸리용에서
        // 탐색의 종료 시점을 어떻게 생각할까?
        // CUR이 END보다 1작거나 START보다 1 클 경우?
    }

    private static long binarySearch(long maxVol) {
        long start = 1;
        long end = maxVol;
        long cur = (start + end) / 2;

        while (start <= end) {
            if (canDrink(cur)) {
                start = cur + 1;
//                System.out.println("YES");
            } else {
                end = cur - 1;
//                System.out.println("NO");
            }
            cur = (start + end) / 2;
//            System.out.println();
        }
        if (canDrink(cur)) {
            return cur;
        } else {
            return cur - 1;
        }
    }

    private static boolean canDrink(long drink) {
        long k = 0;
        if (drink == 0) return true;
        for (int i = 0; i < N; i++) {
            k += pot[i] / drink;
        }
        return K <= k;
    }

}