import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
3
a is b
b is c
c is d
3
a is d
a is c
d is a
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static Map<String, List<String>> map;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            st.nextToken();
            String b = st.nextToken();

            if (!map.containsKey(a)) {
                List<String> l = new ArrayList<>();
                l.add(b);
                map.put(a, l);
            } else {
                List<String> l = map.get(a);
                l.add(b);
            }
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            isTrue = false;
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            st.nextToken();
            String b = st.nextToken();

            check(a, b);
            System.out.println(isTrue?"T":"F");
        }
    }
    static boolean isTrue;

    private static void check(String a, String b) {
        List<String> l = map.get(a);
        if (l == null) return;
        if (l.contains(b)) {
            isTrue = true;
            return;
        }
        for (int i = 0; i < l.size(); i++) {
            check(l.get(i), b);
        }
    }
}