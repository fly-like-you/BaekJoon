/*
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//5 5
//.xx..
//..x..
//.....
//...x.
//...x.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
	static int N;
    static int M;
    static int answer;
    static char[][] map;
    static boolean isSuccess;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for (int x = 0; x < N; x++) {
            isSuccess = false;
            map[x][0] = 'p';
            solution(x, 0);

        }

//        print();
        System.out.println(answer);
    }

    // 열마다 탐색해야함
    // 조건에 맞는 파이프가 발견된다면 파이프배열을 남긴채 종료되어야함
    private static void solution(int x, int y) {
        if (y == M - 1) { // 종료 조건
            isSuccess = true;
            answer++;
            return;
        }
        for (int i = -1; i < 2; i++) {
            if (x+i >= N || x+i < 0 || y+1 >= M|| y+1 < 0 ||map[x+i][y+1] != '.') continue;
            // 그리디하게 탐색

            map[x+i][y+1] = 'p';
            solution(x + i, y + 1);
            if (isSuccess) {
                return;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {

			System.out.println(Arrays.toString(map[i]));
        }
    }

}