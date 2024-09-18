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
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            // 만약 맵에 존재하면 해당
            Integer t = map.get(target);
            if (t != null) {
                sb.append(t).append(" ");
            } else {
                int lb = lowerBound(target);
                int ub = upperBound(target);
                int cnt = ub - lb;
                map.put(target, cnt);
                sb.append(cnt).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int lowerBound(int key) {
        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (cards[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
    private static int upperBound(int key) {
        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (cards[mid] <= key) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */