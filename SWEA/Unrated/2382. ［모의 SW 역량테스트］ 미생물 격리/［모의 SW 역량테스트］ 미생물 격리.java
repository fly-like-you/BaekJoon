
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M, K;
    // 셀의 수, 격리 시간, 미생물 수
    static List<MicroB> micorbs;
    static ArrayList<MicroB>[][] grid;
    static class MicroB {
        int x, y;
        int amount, dir;
        public MicroB(int x, int y, int amount, int dir) {
            this.x = x;
            this.y = y;
            this.amount = amount;
            this.dir = dir;
        }

        public void move() {

            grid[x][y].remove(this);
            this.x = x + dx[dir];
            this.y = y + dy[dir];

            if (this.x == N - 1 || this.x == 0 || this.y == N - 1 || this.y == 0) {
                if (this.amount == 1) {
                    grid[x][y].remove(this);
                    micorbs.remove(this);
                    return;
                }
                this.amount /= 2;
                reverse();
            }
            grid[this.x][this.y].add(this);


        }
        private void reverse() {
            if (this.dir / 2 == 1) {
                this.dir = this.dir == 2 ? 3 : 2;
            } else {
                this.dir = this.dir == 0 ? 1 : 0;
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    public static void main(String[] args) throws IOException {
        // 미생물이 이동했는지 안했는지 표시해주자
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            micorbs = new ArrayList<>();
            grid = new ArrayList[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = new ArrayList<>();
                }
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;
                MicroB micorb = new MicroB(x, y, amount, dir);
                micorbs.add(micorb);
                grid[x][y].add(micorb);
            }

            for (int t = 1; t <= M; t++) {
                // 미생물이 이동함
                // 약품에 맞은 미생물을 반으로 죽이기
                int size = micorbs.size()-1;
                for (int i = size; i >= 0; i--) {
                    micorbs.get(i).move();
                }



                // 이동한 미생물들을 합쳐주기
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (grid[i][j].size() >= 2) {
                            combine(i, j);
                        }
                    }
                }
            }
            int answer = 0;
            for (int i = 0; i < micorbs.size(); i++) {
                answer += micorbs.get(i).amount;
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }

    private static void combine(int r, int c) {
        // 해당 리스트에 있는 모든 미생물들을 제거하고 새로운 미생물을 만들어서 집어넣기
        List<MicroB> m = grid[r][c];
        int amountSum = 0;
        int max = 0;
        int dir = -1;
        int size = m.size();
        for (int i = 0; i < size; i++) {
            MicroB b = m.remove(0);
            micorbs.remove(b);
            amountSum += b.amount;
            if (b.amount > max) {
                dir = b.dir;
                max = b.amount;
            }
        }
        MicroB newM = new MicroB(r, c, amountSum, dir);
        m.add(newM);
        micorbs.add(newM);
    }
}
/*
1
7 2 9
1 1 7 1
2 1 7 1
5 1 5 4
3 2 8 4
4 3 14 1
3 4 3 3
1 5 8 2
3 5 100 1
5 5 1 1
 */