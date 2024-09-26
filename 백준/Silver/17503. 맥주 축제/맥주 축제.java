import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 하루에 맥주 1병만 받을 수 있고, 이전에 받았던 종류의 맥주는 다시 받을 수 없습니다.
    // 마시는 맥주 N개의 선호도 합이 M이상
    // 매일마다 다른 맥주를 마셔야함
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] drinks;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        drinks = new int[K][2];
        // 0은 선호도 1은 도수
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int favor = Integer.parseInt(st.nextToken());
            int alcohol = Integer.parseInt(st.nextToken());
            drinks[i][0] = favor;
            drinks[i][1] = alcohol;
        }

        Arrays.sort(drinks, (d1, d2) -> d1[1] - d2[1]);
        int i = binarySearch();
        if (i == K) {
            System.out.println(-1);
        } else {
            System.out.println(drinks[i][1]);
        }

    }

    public static int binarySearch() {
        int lo = 0;
        int hi = K - 1;
        int minIdx = K;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canDrink(mid) >= M) {
                // 낮춰보기
                hi = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                lo = mid + 1;
            }
        }
        return minIdx;
    }

    static PriorityQueue<int[]> pq = new PriorityQueue<>((d1, d2) -> d2[0] - d1[0]);
    public static int canDrink(int idx) {
        pq.clear();
        // N = 마셔야하는 맥주의 수
        // idx + 1 = 최대한 마실 수 있는 맥주 개수
        if (idx + 1 < N) return 0;
        int sum = 0;
        // 선호도로 간 레벨보다 작은 것에 대해서 정렬
        for (int i = 0; i <= idx; i++) {
            pq.add(drinks[i]);
        }
        // N개 뽑고 합이 선호도 이상이라면 만족
        for (int i = 0; i < N; i++) {
            sum += pq.poll()[0];
        }


        return sum;
    }
}