import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, blank, minTime;
	static boolean flag;
	static int[][] map, copy;
	static ArrayList<Point> virus;
	static boolean[] isSelected;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class Point {
		int y, x, t;

		Point(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		copy = new int[N][N];
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					blank++;
				else if (map[i][j] == 2)
					virus.add(new Point(i, j, 0));
			}
		}

		isSelected = new boolean[virus.size()];
		blank += (virus.size() - M);
		minTime = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(flag ? minTime : -1);
	}

	static void comb(int start, int cnt) {
		if (cnt == M) {
			bfs();
			return;
		}

		for (int i = start; i < virus.size(); i++) {
			isSelected[i] = true;
			comb(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}

	static void bfs() {
		copy();
		int cnt = blank;

		Queue<Point> q = new ArrayDeque<>();
		for (int i = 0; i < virus.size(); i++) {
			Point p = virus.get(i);
			if (isSelected[i]) {
				q.offer(p);
				map[p.y][p.x] = -1;
			} else {
				map[p.y][p.x] = 0;
			}

		}

		int time = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] == 0) {
					map[ny][nx] = p.t + 1;
					q.offer(new Point(ny, nx, p.t + 1));
					cnt--;
				}
			}
			if (time != p.t)
				time = p.t;
		}
		if (cnt == 0) {
			flag = true;
			minTime = Math.min(minTime, time);
		}
	}

	static void copy() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(copy[i], 0, map[i], 0, N);
		}
	}
}