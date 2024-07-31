import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 배열의 크기
    static int R; // 놓을 수 있는 바이러스 수
    static int C; // 총 바이러스 수
    static int[][] arr;
    static int[][] copy;
    static int blank;
    static int minTime;
    static boolean flag;

    static ArrayList<Point> virus;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        copy = new int[N][N];
        virus = new ArrayList<>();
        minTime = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int elem = Integer.parseInt(st.nextToken());
                arr[i][j] = copy[i][j] = elem;
                if (elem == 0) {
                    blank++;
                }
                if (elem == 2) {
                    virus.add(new Point(i, j));
                    C++;
                }
            }
        }
        blank += C - R;
        selected = new boolean[C];
        combination(0, R);
        System.out.println(flag ? minTime-1 : -1);
    }

    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {1, -1 , 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static void bfs() {
        int cnt = 0;
        copy();
        for (int i = 0; i < C; i++) {
            Point p = virus.get(i);
            if (selected[i]) {
                q.add(p);
                arr[p.x][p.y] = 1;
            } else {
                arr[p.x][p.y] = 0;
            }
        }

        int time = 1;
        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                    time = Math.max(arr[nx][ny], time);
                    q.add(new Point(nx, ny));
                    cnt++;
                }
            }
        }
        if (cnt == blank) {
            minTime = Math.min(time, minTime);
            flag = true;
        }

    }

    private static void combination(int start, int end) {
        if (end == 0) {
            bfs();
        }

        for (int i = start; i < virus.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                combination(start + 1, end - 1);
                selected[i] = false;
            }
        }
    }

    static class Point {
        int x; int y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static void copy() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(copy[i], 0, arr[i], 0, N);
        }
    }

}