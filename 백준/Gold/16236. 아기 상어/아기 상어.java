import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
// 크기는 2부터 시작
// 1초에 상하좌우로 한칸씩이동
// 큰 물고기로 지나갈 수 없음
// 같거나 큰 물고기는 못 먹음
// 종료 조건
// 먹을 수 있는 물고기가 없다
// 물고기가 1마리 -> 먹으러감
// 1마리보다 많으면 -> 가장 가까운 물고기
// 가까운 고기가 많으면 가장 위에 있는 고기, 그것도 여러개면 가장 왼쪽 (상, 좌 우선)
// 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기 1증가
public class Main {
    // 자신의 크기를 기준으로 BFS 탐색
    // 탐색할 때 위와 왼쪽을 우선순위로 주자
    // 시간 += BFS로 최단거리 물고기까지의 거리
    // 종료 조건 자신의 크기보다 작은 물고기들이 없을 때
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] field;
    static Shark shark;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                field[i][j] = v;
                if (v == 9) {
                    shark = new Shark(i, j, 2);
                    field[i][j] = 0;
                }
            }
        }
        int time = 0;
        int grow = 0;
        while (true) {
            int t = shark.search();
            if (t < 0) {
                break;
            }
            grow++;
            time += t;
            if (grow == shark.size) {
                grow = 0;
                shark.size++;
            }
        }
        System.out.println(time);
    }

    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dx = {-1, 0, 0 , 1}; // 상 좌 우 좌
    static int[] dy = {0, -1, 1, 0};
    static class Shark {
        int x, y;
        int size;

        public Shark(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public int search() {
            // 물고기들을 찾는 메서드
            // 물고기를 못찾으면 -1 리턴
            q.clear();
            int path = 0;
            boolean[][] visited = new boolean[N][N];
            q.offer(new int[]{this.x, this.y});
            visited[this.x][this.y] = true;

            // 먹이 후보들을 담아둘 배열선언
            int feedX = Integer.MAX_VALUE;
            int feedY = Integer.MAX_VALUE;
            // 자신보다 작은 물고기를 찾으면 리턴
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int[] n = q.poll();
                    int x = n[0], y = n[1];
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (visited[nx][ny]) continue;
                        if (field[nx][ny] > this.size) continue; // 자신보다 사이즈가 크면 리턴
                        if (field[nx][ny] != 0 && field[nx][ny] < this.size) {
                            if (nx < feedX || (nx == feedX && ny < feedY)) {
                                feedX = nx;
                                feedY = ny;
                            }
                            continue;
                        }

                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
                path++;
                // 먹이를 찾으면 먹이중 가장 위쪽, 왼쪽의 먹이만 먹고 리턴해주기
                if (feedX != Integer.MAX_VALUE){
                    this.x = feedX;
                    this.y = feedY;
                    field[this.x][this.y] = 0;
                    return path;
                }
            }
            return -1;
        }
    }
}
/*
둘째 줄부터 N개의 줄에 공간의 상태가 주어진다.
공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있다.

0: 빈 칸
1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
9: 아기 상어의 위치
3
0 0 0
0 0 0
0 9 0
6
1 6 6 6 6 6
0 6 0 0 0 1
0 6 0 6 6 6
0 0 9 6 6 6
6 6 6 6 6 6
6 6 6 6 6 6
 */