import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static class Staff {
        int chip;
        int cur;
        int[] scores;

        public Staff(int chip, int votes, int[] scores) {
            this.chip = chip;
            this.cur = votes;
            this.scores = scores;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int X, N;
    static HashMap<Character, Staff> map;

    public static void main(String[] args) throws IOException {
        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        int outVotes = (int) (X * 0.05);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char staff = st.nextToken().charAt(0);
            int votes = Integer.parseInt(st.nextToken());
            int[] scores = new int[15];
            for (int j = 1; j <= 14; j++) {
                scores[j] = votes / j;
            }
            if (votes >= outVotes) {
                map.put(staff, new Staff(0, 1, scores));
            }
        }

        // 14번 반복
        // 각 인덱스에서 가장 높은

        for (int i = 0; i < 14; i++) {
            char maxKey = ' ';
            int max = -1;
            for (char key : map.keySet()) {
                // 가장 높은 값 찾기
                // 찾으면 해당 키의 인덱스를 더해주기
                Staff staff = map.get(key);
                if (staff.scores[staff.cur] > max) {
                    maxKey = key;
                    max = staff.scores[staff.cur];
                }
            }
            map.get(maxKey).chip++;
            map.get(maxKey).cur++;
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            if (map.containsKey(i)) {
                System.out.println(i + " " + map.get(i).chip);
            }
        }
    }
}