import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int R;
    static int C;
    static char[][] yard;
    static boolean[][] visited;
    static int tSheep;
    static int tWolf;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Deque<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        yard = new char[R][];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            yard[i] = st.nextToken().toCharArray();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) continue;
                if (yard[i][j] == 'v'){
                    solution(new Point(i, j), 1, 0);
                } else if (yard[i][j] == 'k') {
                    solution(new Point(i, j), 0, 1);
                }
            }
        }
        System.out.println(tSheep + " " + tWolf);
    }

    private static void solution(Point p, int wolf, int sheep) {
        queue.addFirst(p);
        visited[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point node = queue.pollLast();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (yard[nx][ny] == '#') continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.addFirst(new Point(nx, ny));
                if (yard[nx][ny] == 'v') {
                    wolf++;
                } else if (yard[nx][ny] == 'k') {
                    sheep++;
                }
            }
        }

        if (sheep > wolf) {
            tSheep += sheep;
        } else {
            tWolf += wolf;
        }
    }
    static class Point {
        int x; int y;
        Point(int x, int y) {this.x = x; this.y = y;}
    }
}

