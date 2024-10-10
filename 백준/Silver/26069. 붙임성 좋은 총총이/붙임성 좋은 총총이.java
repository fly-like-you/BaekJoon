import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashSet<String> set;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String names = br.readLine();
            st = new StringTokenizer(names);
            String a = st.nextToken();
            String b = st.nextToken();
            if (names.contains("ChongChong")) {
                set.add(a);
                set.add(b);
                answer = 2;
                continue;
            }

            if (!set.isEmpty()) {
                if (set.contains(a)) {
                    set.add(b);
                } else if (set.contains(b)) {
                    set.add(a);
                }
            }
        }
        System.out.println(set.size());
    }
}
/*
ChongChong jthis jyheo98 lms0806

 */