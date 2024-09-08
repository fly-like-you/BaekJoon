import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[] A = {'0', '0', '0', '0', '0',  '0', '0', '0', '0', '0',
            '0', '0', '0', '0', '0',  '0', '0', '0', '0', '0'};
    static char[] B = {
            '1', '1', '1', '1', '1',
            '1', '1', '1', '1', '1',
            '1', '1', '1', '1', '1',
            '1', '1', '1', '1', '1',
    };
    static int T, D, W, K;
    static int injectionCnt;
    static int isSuccess;
    static boolean[] injection;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new char[D][W];
            injection = new boolean[D];
            injectionCnt = 0;

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }
//            combination(0, 0, 1);

            for (int d = 0; d < D; d++) {
                isSuccess = 0;
                combination(0, 0, d);
                if (isSuccess > 0) {
                    injectionCnt = d;
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append(injectionCnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void combination(int depth, int prev, int R) {
        if (isSuccess > 0) return;
        if (depth == R) {
            // 약품 주입해보기
            if (isSuccess()) {
                isSuccess++;
            }
            return;
        }

        for (int i = prev; i < D; i++) {
            // 약물을 주입할 배열을 true로 바꿔주기
            char[] temp = map[i].clone();
            map[i] = A;
            combination(depth + 1, i + 1, R);

            map[i] = B;
            combination(depth + 1, i + 1, R);

            map[i] = temp;
        }
    }



    private static boolean isSuccess() {

        A: for (int j = 0; j < W; j++) {
            int length = 1;
            char cur = map[0][j];
            for (int i = 1; i < D; i++) {
                // map[i][j] -> 행우선 탐색
                if (map[i][j] == cur) {
                    length++;
                    if (length == K) {
                        continue A;
                    }
                } else {
                    length = 1;
                }
                cur = map[i][j];
            }
            return false;
        }
        return true;
    }
}

/*
1. 약품 투입 위치 결정하기 (2개 가정, 순서 필요 없음, 중복 풀가능 -> 조합)
2. 위치에 대해서 (A, B), (B, A)등 가능한 조합 시도하기 (순서 필요, 중복가능 -> 중복 순열 )
3. 하던중에 테스트를 통과하면 종료
 */
/*
1
6 8 3
0 0 1 0 1 0 0 1
0 1 0 0 0 1 1 1
0 1 1 1 0 0 0 0
1 1 1 1 0 0 0 1
0 1 1 0 1 0 0 1
1 0 1 0 1 1 0 1

1
6 4 4
1 1 0 0
0 1 0 1
1 1 0 1
1 1 0 1
1 1 0 1
1 0 1 0
 */