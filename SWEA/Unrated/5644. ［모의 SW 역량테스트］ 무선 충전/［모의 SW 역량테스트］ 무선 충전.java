import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 1
 20 3
 2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
 4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
 4 4 1 100
 7 10 3 40
 6 3 2 70

 */
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int TC;
    static int A, T;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static Phone p1;
    static Phone p2;
    static BatteryCharger[] bc;
    static int maxBattery;
    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            T = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            maxBattery = 0;

            st = new StringTokenizer(br.readLine().trim());
            int[][] ph = new int[T+1][2];
            ph[0] = new int[] {1, 1};
            for (int i = 1; i <= T; i++) {
                int dir = Integer.parseInt(st.nextToken());
                ph[i][0] = ph[i - 1][0] + dx[dir];
                ph[i][1] = ph[i - 1][1] + dy[dir];
            }
            p1 = new Phone(ph);

            st = new StringTokenizer(br.readLine().trim());
            int[][] ph2 = new int[T+1][2];
            ph2[0] = new int[] {10, 10};
            for (int i = 1; i <= T; i++) {
                int dir = Integer.parseInt(st.nextToken());
                ph2[i][0] = ph2[i - 1][0] + dx[dir];
                ph2[i][1] = ph2[i - 1][1] + dy[dir];
            }
            p2 = new Phone(ph2);

            bc = new BatteryCharger[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bc[i] = new BatteryCharger(i+1, new int[]{y, x}, c, p);
            }

            for (int t = 0; t <= T; t++) {
                p1.detect();
                p2.detect();

                // 그리디 두개
                maxBattery += maxSum(p1.detected, p2.detected);
                p1.move();
                p2.move();
            }

            sb.append("#").append(tc).append(" ").append(maxBattery).append("\n");
        }
        System.out.println(sb);

    }
    public static int maxSum(BatteryCharger[] d1, BatteryCharger[] d2) {
        // 내림차순정렬
        Arrays.sort(d1);
        Arrays.sort(d2);

        return calculatePrice(d1, d2);
    }

    public static int calculatePrice(BatteryCharger[] d1, BatteryCharger[] d2) {
        boolean isSamePrice = d1[0].p == d2[0].p;
        boolean isSameId = d1[0].id == d2[0].id;

        if (!isSamePrice) return d1[0].p + d2[0].p;
        if (isSameId) return d1[0].p + Math.max(d1[1].p, d2[1].p);
        return d1[0].p * 2;
    }

    static class Phone {
        int[][] path;
        BatteryCharger[] detected = new BatteryCharger[8];
        int cur;

        public Phone(int[][] path) {
            this.path = path;
            cur = 0;
        }

        public void move() {
            cur++;
        }

        public void detect() {
            int[] now = path[cur];
            int idx = 0;
            Arrays.fill(detected, new BatteryCharger(1000, new int[]{0, 0}, 0, 0));
            for (BatteryCharger b : bc) {
                if (b.canCharge(now)) {
                    detected[idx++] = b;
                }
            }
        }
    }

    static class BatteryCharger implements Comparable<BatteryCharger>{
        int id;
        int[] location;
        int coverage;
        int p;

        public BatteryCharger(int id, int[] location, int coverage, int p) {
            this.id = id;
            this.location = location;
            this.coverage = coverage;
            this.p = p;
        }

        public boolean canCharge(int[] p) {
            return Math.abs(p[0] - location[0]) + Math.abs(p[1] - location[1]) <= coverage;
        }

        @Override
        public int compareTo(BatteryCharger o) {
            return o.p - this.p;
        }

        @Override
        public String toString() {
            return "BatteryCharger{" +
                    "id=" + id +
                    ", location=" + Arrays.toString(location) +
                    ", coverage=" + coverage +
                    ", p=" + p +
                    '}';
        }
    }


}