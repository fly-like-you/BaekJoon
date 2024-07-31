import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static String[][] arr;
    static int[][] times;

    static ArrayList<Integer> answer; // -> answer 하기
    static ArrayList<Point> points;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        arr = new String[N][N];
        times = new int[N][N];
        points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken();
                if (arr[i][j].equals("2")) {
                    points.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[points.size()];
        combination(0, M);

        int r = Integer.MAX_VALUE;
        for (int i = 0; i < answer.size(); i++) {
            r = Math.min(answer.get(i), r);
        }
        if (r == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(r - 1);

        }

    }

    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {1, -1 , 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static void bfs() {
        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                String lab = arr[nx][ny];
                if (lab.equals("1")) continue;
                if (times[nx][ny] == 0) {
                    times[nx][ny] = times[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }

            }
        }
    }

    private static void combination(int start, int end) {
        if (end == 0) {
            times = new int[N][N];
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    times[points.get(i).x][points.get(i).y] = 1;
                    q.add(points.get(i));
                }
            }

            // bfs 실행
            bfs();

            // 해당 배열이 성공했나?
            // 성공 했다면 시간은 얼마인가?
            int rtv = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rtv = Math.max(times[i][j], rtv);
                    if (!arr[i][j].equals("1") && times[i][j] == 0) { // 실패
                        return;
                    }
                }
            }
            answer.add(rtv);
            return;
        }

        for (int i = start; i < points.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(start + 1, end - 1);
                visited[i] = false;
            }

        }
    }

    static class Point {
        int x; int y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

}