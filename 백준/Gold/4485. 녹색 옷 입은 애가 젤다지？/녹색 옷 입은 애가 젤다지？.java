
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 */
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int[][] map;
    static int[][] dist;

    static class Vertex implements Comparable<Vertex> {
        int x, y;
        int weight;

        public Vertex(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return weight - o.weight;    //비용기준 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int tc = 1;	//테스트 케이스
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break; //0입력 받으면 중지

            map = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();

            sb.append("Problem ").append(tc).append(": ").append(dist[N-1][N-1]).append('\n');
            tc++;
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        boolean[][] visited = new boolean[N][N];

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = map[0][0];

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Vertex n = pq.poll();
            int x = n.x;
            int y = n.y;

            if (visited[x][y]) continue;
            if (x == N-1 && y == N - 1) return;

            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (dist[nx][ny] <= dist[x][y] + map[nx][ny]) continue;

                dist[nx][ny] = dist[x][y] + map[nx][ny];
                pq.offer(new Vertex(nx, ny, dist[nx][ny]));
            }
        }
    }
}