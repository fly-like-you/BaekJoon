import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 종으로부터 특정 거리 R 이내에 있는 사람은 모두 들을 수 있고
 R보다 멀리 떨어져 있는 사람은 모두 들을 수 없다

 매번 종을 칠 때마다 R의 값은 바뀐다

 N명의 사람 각각이 각 M번의 타종을 들었는지의 여부가 주어졌을 때, 실제로 가능한 상황인지 판별하여라.
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static String[] sound;
    public static void main(String[] args) throws IOException {
        // 일단 정렬
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if (N == 1) {
            System.out.println("YES");
            return;
        }
        sound = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(st.nextToken());
            }
            sound[i] = sb.toString();
        }

        Arrays.sort(sound, Collections.reverseOrder());

        for (int i = 0; i < M; i++) {
            // M번의 타종을 칠때
            char cur = sound[1].charAt(i);
            char prev = sound[0].charAt(i);
            for (int j = 1; j < N; j++) {
                // 세로 줄에서 1 -> 0 -> 1 가는 순간 False
                cur = sound[j].charAt(i);
                prev = sound[j-1].charAt(i);
                if (prev < cur) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }
}
/*
1 2
1 1
1번 사람이 1번째 타종을 들을 수 있다.

1 0
0 1
1번 사람이 1번째 타종을 듣고 2번째 타종을 듣지 못했다.
2번 사람이 1번째 타종을 듣지 못했고 2번째 타종을 들었다.
1번 타종으로 1번 사람이 2번사람보다 가까이있다.
2번 타종으로 2번 사람이 1번사람보다 가까이 있다. (모순)

처음 타종으로 1, 0 순으로 정렬을하면 가까운 거리를 알 수 있다.
i + 1 타종으로 1, 0순으로 정렬했을 때
3 7
1 1 0 1 1 1 1
1 1 0 1 1 1 0
1 1 0 1 1 0 1
모순이 생기는 지점은 내림차순으로 정렬하였을 때

1번 2번 사람이 순서가 없다?
1번사람이 더 가깝다
2번 사람이 멀다
R = 1
0 0 0 0 1 1
0 1 1 1 1 1
 */