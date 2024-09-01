import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 메모리:25,296kb, 시간:153ms
 * 
 * [문제 해석]
 */

/*
1
4
0 1 0 0
1 1 1 0
0 0 1 1
0 0 0 0

answer = 4
wrong = 2
* */
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N;
    static int[][] circuit;
    static ArrayList<Core> cores;

    static int minWire;
    static int maxPower;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T ; t++) {
            N = Integer.parseInt(br.readLine());
            circuit = new int[N][N];
            minWire = Integer.MAX_VALUE;
            maxPower = 0;
            cores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    circuit[i][j] = value;
                    if (value == 1 && i != 0 && i != N-1 && j != 0 && j != N-1) {
                        cores.add(new Core(i, j));
                    }
                }
            }

            solution(0, 0, 0);
            sb.append("#").append(t).append(" ").append(minWire).append("\n");
        }
        System.out.println(sb);
    }

    /*
    @param depth 현재 시도해본 코어의 개수
    @param wireSum 전선의 합
    @param power 전원에 연결된 코어의 개수
    @param prev 조합에 사용
    */

    private static void solution(int depth, int wireSum, int power) {

        if (maxPower > power + (cores.size() - depth)) {
            return;
        }
        if (depth == cores.size()) {
            // power가 maxPower보다 작으면 패스
            if (power < maxPower) {
                return;
            } else if (power == maxPower) {
                minWire = Math.min(wireSum, minWire);
            } else {
                maxPower = power;
                minWire = wireSum;
            }
            return;
        }

        Core core = cores.get(depth);
        int[][] temp = new int[N][N];
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                temp[k][j] = circuit[k][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            // 위 오 왼 아
            // 설치하기
            // 현재
            // 조건에 맞는다면 전선의 길이를 리턴 맞지않으면 전선의 길이는

            int wire = core.install(i);

            // 다음 코어 탐색하기
            if (wire == 0) {
                solution(depth + 1, wireSum, power);
            } else {
                solution(depth + 1, wireSum + wire, power + 1);
            }

            // 회로를 원상복구 시키기
            copyArray(temp);
        }
    }


    static void copyArray(int[][] temp) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(temp[i], 0, circuit[i], 0, temp[i].length);
        }
    }

    static class Core {
        int x, y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int install(int dir) {
            int wire = 0;

            // 전선이 조건에 맞는지 확인하기
            if (canInstall(dir)) {
                // 조건에 맞는 경우 circuit 배열에 전선을 연결
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                while (true) {
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                    circuit[nx][ny] = 2;
                    wire++;
                    nx += dx[dir];
                    ny += dy[dir];
                }
                return wire;
            }

            return 0;
        }

        // 전선이 다른전선과 겹치면 안됨
        // 전선이 다른 코어와 연결되면 안됨
        // 또는
        // 맵의 바깥까지 전선을 연결, 0이 아닌 값이 들어오면 false;
        boolean canInstall(int dir) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            while (true) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                if (circuit[nx][ny] != 0) return false;

                nx += dx[dir];
                ny += dy[dir];
            }

            return true;
        }
    }
}