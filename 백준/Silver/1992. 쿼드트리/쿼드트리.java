import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static char[][] file;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        file = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            file[i] = st.nextToken().toCharArray();
        }
        solution(0, 0, N);
        System.out.println(sb);
    }
    private static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(file[i]));
        }
    }

    private static void solution(int x, int y, int size) {
        int bitSum = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (file[i][j] == '1') {
                    bitSum++;
                }
            }
        }

        // 모든 비트가 0 인 경우
        if (bitSum == 0) {
            sb.append(0);
        } else if (bitSum == size * size) {
            // 모든 비트가 1인 경우
            sb.append(1);
        } else {
            // 비트가 다른 경우 -> 재귀
            int newSize = size / 2;
            sb.append("(");
            solution(x, y, newSize);
            solution(x, y + newSize, newSize);
            solution(x + newSize, y, newSize);
            solution(x + newSize, y + newSize, newSize);
            sb.append(")");
        }
    }

}

//8
//11110000
//11110000
//00011100
//00011100
//11110000
//11110000
//11110011
//11110011