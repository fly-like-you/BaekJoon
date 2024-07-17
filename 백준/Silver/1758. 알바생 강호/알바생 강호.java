import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static BufferedReader br;
    static int N;
    static Integer[] tips;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tips = new Integer[N];
        for (int i = 0; i < N; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순으로 정렬한다.
        Arrays.sort(tips, Collections.reverseOrder());
        // 팁 계산한다.
        System.out.println(solution());
    }

    private static long solution() {
        long tipSum = 0;
        for (int i = 1; i <= N; i++) {
            long tip = tips[i - 1] - (i - 1);
            tipSum += (tip >= 0) ? tip : 0;
        }
        return tipSum;
    }
}
