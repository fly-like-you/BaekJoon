

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 운영진이 좋아하는 이름이란,
 맨 뒷글자는 알파벳 자음(A부터 Z 중 A, E, I, O, U를 제외한 글자들)이고,
  뒤에서부터 각각 두 번째와 세 번째 글자는 A인 문자열이다.
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static char[] str;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        str = br.readLine().toCharArray();
        int length = 0;

        for (int i = N-1; i >= 0; i--) {
            // 길이가 M이고
            // 뒤에서부터 자음
            if (length == 0 && 자음인가요(str[i])) { // 자음 탐색
                sb.append(str[i]);
                length++;
                continue;
            }

            if ((length == 1 || length == 2) && str[i] == 'A') {
                sb.append('A');
                length++;
                continue;
            }

            if (length > 2 && length < M) {
                sb.append(str[i]);
                length++;
            }
        }
        if (length != M) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(sb.reverse());
        }
    }

    private static boolean 자음인가요(char chr) {
        return !(chr == 'A' || chr == 'E' || chr == 'I' || chr == 'O' || chr == 'U');
    }
}

/*
7 5
IKSAXAC
* */