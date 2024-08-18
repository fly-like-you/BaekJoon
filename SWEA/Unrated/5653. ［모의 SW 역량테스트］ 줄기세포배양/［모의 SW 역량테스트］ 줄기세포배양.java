import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int N; // 배열의 크기
    static int M;
    static int K;
    static int T;
    static boolean[][] grid;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static PriorityQueue<Cell> pq;
    static List<Cell> cells;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ").append(solution()).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        cells = new ArrayList<>();
        grid = new boolean[N + 2*K][M + 2*K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int life = Integer.parseInt(st.nextToken());
                int x = i + K;
                int y = j + K;
                if (life > 0) {
                    Cell cell = new Cell(new int[]{x, y}, life, life * -1);
                    grid[x][y] = true;
                    cells.add(cell);
                }
            }
        }


        for (int i = 0; i <= K; i++) {
            while (!pq.isEmpty()) {

                Cell cell = pq.poll();
                if (!grid[cell.p[0]][cell.p[1]]) {
                    grid[cell.p[0]][cell.p[1]] = true;
                    cells.add(cell);
                }
            }

            for (int j = 0; j < cells.size(); j++) {
                Cell cell = cells.get(j);
                cell.time();
            }

        }

        return count();
    }

    static private int count() {
        int count = 0;
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).status == Status.ACTIVE || cells.get(i).status == Status.DEACTIVATE) {
                count++;
            }
//            if (cells.get(i).status == Status.DIE) {
//                count++;
//            }
//            System.out.println(cells.get(i).status);
        }

        return count;
    }

    static class Cell implements Comparable<Cell> {
        int[] p;
        int life;
        int age;
        Status status;

        public Cell(int[] p, int life, int age) {
            this.p = p;
            this.life = life;
            this.age = age;
            this.status = Status.DEACTIVATE;
        }

        public void time() {

            if (age >= life) {
                this.status = Status.DIE;
            } else if (age >= 0) {
                if (age == 0) {
                    crossover();
                }
                this.status = Status.ACTIVE;
            }
            this.age++;
        }

        // 번식
        public void crossover() {
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                Cell target = new Cell(new int[]{nx, ny}, this.life, this.life * -1);
                pq.add(target);
            }
        }


        @Override
        public int compareTo(Cell o) {
            return o.life-this.life;
        }
    }
    enum Status {
        DEACTIVATE, ACTIVE,  DIE
    }

}