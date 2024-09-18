import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] cards;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        cards = new int[N];
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            Integer t = map.getOrDefault(v, 0);
            map.put(v, ++t);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());

            sb.append(map.getOrDefault(v, 0)).append(" ");

        }

        System.out.println(sb);
    }

}
/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */