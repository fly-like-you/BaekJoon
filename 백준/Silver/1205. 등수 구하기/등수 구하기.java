import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, T, P;
    static int[] rank;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        // N <= P
        // 3
        if (N == 0) {
            System.out.println(1);
            return;
        }


        rank = new int[N];
        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        scores[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i-1] == scores[i]) {
                rank[i] = rank[i-1];
            } else {
                rank[i] = i;
            }
        }
        if (N == P && T <= scores[N - 1]) {
            System.out.println(-1);
            return;
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (T >= scores[i]) {
                System.out.println(rank[i] + 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(N + 1);
        }


    }

}
/*

10 0 10
10 9 8 7 6 5 4 3 2 1
 */