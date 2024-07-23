import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String roomString = br.readLine();
            if (roomString == null) break;

            st = new StringTokenizer(roomString);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int answer = 0;
            for (int i = N; i <= M; i++) {
                String s = String.valueOf(i);
                Set<Character> set = new HashSet<>();
                for (int j = 0; j < s.length(); j++) {
                    set.add(s.charAt(j));
                }

                if (set.size() == s.length()) {
                    answer++;
                }
            }
            System.out.println(answer);
        }

    }

}