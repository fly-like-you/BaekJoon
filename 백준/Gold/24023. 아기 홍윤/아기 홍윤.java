import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int cur = 0;
        for (int i = 0; i < N; i++) {
            cur |= arr[i];
            if (cur == K) {
                System.out.println((s + 1) + " " + (i + 1));
                return;
            }
            if ((cur | K) != K || cur > K) {
                s = i + 1;
                cur = 0;
            }

        }
        System.out.println(-1);
        // 될 때까지 늘린다.
        // 안되면 해당 인덱스 바로 다음부터 다시 시작
        // 어쩌면 안되나? 현재 값과 K값의 & 결과가 0이면 끝

    }
}
/*
5 7
8 1 2 3 7
5 7
8 10 1 2 55
5 7
10 10 10 10 7
5 7
7 10 10 10 10
5 6
1 5 2 4 1
 */