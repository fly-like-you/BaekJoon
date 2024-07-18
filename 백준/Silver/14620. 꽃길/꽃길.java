import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int minPrice = Integer.MAX_VALUE;
    static boolean[][] visited;
    static Point[] plants = new Point[3];
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(1, 1, 0);
        System.out.println(minPrice);
    }

    private static void solution(int x, int y, int count) {
        if (count == 3) {
        	
            if (isPlant()) {
                minPrice = Math.min(minPrice, calcPrice());
            }
        } else {
            for (int i = x; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                	
                    if (!visited[i][j]) {
                    	
                        visited[i][j] = true;
                        solution(i, j, count + 1);
                        visited[i][j] = false;
                    }

                }
            }
        }
    }

    private static int calcPrice() {
        int price = 0;
        int[] dx = {1, -1, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0};
        for (int i = 0; i < 3; i++) {
            Point p = plants[i];
            for (int j = 0; j < 5; j++) {
                int nx = dx[j] + p.x;
                int ny = dy[j] + p.y;

                price += map[nx][ny];
            }
        }
        return price;
    }


    private static boolean isPlant() {

        int c = 0;
        A: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    plants[c++] = new Point(i, j);
                    if (c == 3) {
                        break A;
                    }
                }
            }
        }

        Point p1 = plants[0];
        Point p2 = plants[1];
        Point p3 = plants[2];

        
        
        
        return temp(p1, p2) && temp(p1, p3) && temp(p2, p3);
    }

    private static boolean temp(Point p1, Point p2) {
        int[] dx = {2, 1, 1, 0, 0, -1, -1, -2, 1, -1, 0, 0, 0};
        int[] dy = {0, -1, 1, -2, 2, -1, 1, 0, 0, 0, 1, -1, 0};

        for (int i = 0; i < 13; i++) {
            int nx = dx[i] + p1.x;
            int ny = dy[i] + p1.y;

            if (p2.x == nx && p2.y == ny) {
                return false;
            }
        }
        return true;
    }
    static class Point{
        int x; int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        
    }
}