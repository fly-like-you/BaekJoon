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
        N = Integer.parseInt(st.nextToken());  // 선호도를 만족해야 하는 맥주의 개수
        M = Integer.parseInt(st.nextToken());  // 필요한 최소 선호도
        K = Integer.parseInt(st.nextToken());  // 총 맥주의 종류 수

        beers = new int[K][2]; // [선호도, 가격]
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(st.nextToken());  // 선호도
            beers[i][1] = Integer.parseInt(st.nextToken());  // 가격
        }

        // 맥주를 가격을 기준으로 오름차순 정렬
        Arrays.sort(beers, Comparator.comparingInt(b -> b[1]));

        // 선호도를 관리할 우선순위 큐 (최소 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int favor = 0; // 선호도의 합
        int answer = -1; // 답이 없으면 -1 출력

        // 모든 맥주를 순차적으로 확인
        for (int i = 0; i < K; i++) {
            pq.add(beers[i][0]);  // 현재 맥주의 선호도를 추가
            favor += beers[i][0]; // 선호도 합 계산

            // 우선순위 큐의 크기가 N을 넘으면 가장 작은 선호도를 제거
            if (pq.size() > N) {
                favor -= pq.poll();
            }

            // N개의 맥주를 선택했고, 선호도의 합이 M 이상일 때
            if (pq.size() == N && favor >= M) {
                answer = beers[i][1]; // 현재 맥주의 가격이 가장 저렴한 가격이 됨
                break;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}