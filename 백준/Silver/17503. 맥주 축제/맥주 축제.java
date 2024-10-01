import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] beers;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        beers = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(st.nextToken());
            beers[i][1] = Integer.parseInt(st.nextToken());
        }
        // 맥주를 간 수치를 기준으로 정렬하기
        Arrays.sort(beers, Comparator.comparingInt(b -> b[1]));

        // pq에 윈도우크기만큼(N) 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // init
        int end = N - 1;
        int favor = 0;
        for (int i = 0; i < N; i++) {
            pq.add(beers[i][0]);
            favor += beers[i][0];
        }
        int answer = -1;
        // 윈도우를 움직이면서 선호도를 만족하는지 확인하기
        while (true) {
            if (favor >= M) {
                answer = beers[end][1];
                break;
            }

            end++;
            if (end >= K) break;
            pq.add(beers[end][0]);
            favor += beers[end][0];
            favor -= pq.poll();

        }
        System.out.println(answer);

    }

}
/*
3 9 5
2 5
4 6
3 3
4 3
1 4

6 60 6
10 1
10 2
10 3
10 4
10 5
10 6
 */