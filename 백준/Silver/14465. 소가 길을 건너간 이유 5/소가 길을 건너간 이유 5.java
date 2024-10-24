import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 1번부터 N번까지의 번호가 붙은 횡단보도 N (1 ≤ N ≤ 100,000)개로 이루어져 있다.
존은 각 횡단보도에 신호등을 설치해 놓았다.
 그러던 어느 날, 강력한 뇌우로 인해 몇몇 신호등이 망가졌다.
 존은 연속한 K개의 신호등이 존재하도록 신호등을 수리하고 싶다.
 */
public class Main {
    static int N, K, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] broken;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        broken = new boolean[N + 1];

        for (int i = 0; i < B; i++) {
            int idx = Integer.parseInt(br.readLine());
            broken[idx] = true;
        }

        int cost = 0;
        int lowCost = Integer.MAX_VALUE;
        for (int i = 1; i < K + 1; i++) {
            if (broken[i]) cost++;
        }
        for (int i = K + 1; i < N + 1; i++) {
            if (broken[i]) cost++;
            if (broken[i-K]) cost--;

            lowCost = Math.min(lowCost, cost);
        }
        System.out.println(lowCost);
    }
}