import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int K;
    static Integer[] towers;
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        towers = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(solution());

    }

    private static Integer solution() {

        for (int i = 1; i <= 1000; i++) {
            int count = 0;
            int firstTower = i;

            for (int j = 1; j < N; j++) {
                int temp = firstTower + j * K;
                if (towers[j] != temp) {
                    count++;
                }
            }
            if (firstTower != towers[0]) count++;

            minCount = Math.min(minCount, count);
        }


        return minCount;
    }
}