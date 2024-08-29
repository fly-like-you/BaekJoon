import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 5 5 1
 0 0 0 0 0
 0 0 0 0 0
 0 0 0 0 0
 0 0 0 0 0
 1 1 1 1 1

 4 4 4
 1 1 1 0
 1 1 1 1
 0 0 1 0
 0 0 1 1
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, D;
	static int R = 3;
	static char[][] castle;
	static int[] archer;
	static int maxCnt;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		archer = new int[R];

		castle = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				castle[i][j] = st.nextToken().charAt(0);
			}
		}

		solution(0, 0);
		System.out.println(maxCnt);
	}

	// 조합
	private static void solution(int depth, int prev) {
		if (depth == R) {
			Archer[] archers = new Archer[R];

			char[][] temp = new char[N][];
			for (int i = 0; i < N; i++) {
				temp[i] = Arrays.copyOf(castle[i], M);
			}
			for (int i = 0; i < R; i++) {
				archers[i] = new Archer(new P(N, archer[i]));
			}
			int cnt = simulation(archers, temp);
			maxCnt = Math.max(cnt, maxCnt);
			return;
		}

		for (int i = prev; i < M; i++) {
			archer[depth] = i;
			solution(depth + 1, i + 1);
		}
	}

	private static int simulation(Archer[] archers, char[][] temp) {
		int cnt = 0;
		P[] enemy = new P[R];
		// N의 시간 동안 시뮬레이션 실행
		for (int t = 0; t < N; t++) {
			// 궁수가 적을 죽이고
			for (int i = 0; i < R; i++) {
				enemy[i] = archers[i].attack(temp);
			}
			for (int i = 0; i < R; i++) {
				if (enemy[i] == null) continue;
				int x = enemy[i].x;
				int y = enemy[i].y;
				if (temp[x][y] == '1') {
					temp[x][y] = '0';
					cnt++;
				}
			}

			// 벽을 한칸 내리기
			System.arraycopy(temp, 0,  temp, 1 , N-1);
			char[] te = new char[M];
			Arrays.fill(te, '0');
			temp[0] =te;
//			System.out.println(t + ": " + cnt);
		}


		return cnt;
	}

	static int[] dx = {0, -1, 0};
	static int[] dy = {-1, 0, 1};
	static Queue<P> q = new ArrayDeque<>();
	static class Archer {
		P p;
		public Archer(P p) {
			this.p = p;
		}

		public P attack(char[][] temp) {
			boolean[][] visited = new boolean[N][M];
			q.clear();
			// bfs로 적 탐색
			q.offer(new P(p.x, p.y)); // 자신의 바로 위에서부터 탐색

			while (!q.isEmpty()) {
				P point = q.poll();

				for (int i = 0; i < dx.length; i++) {
					int nx = point.x + dx[i];
					int ny = point.y + dy[i];
					P p2 = new P(nx, ny);

					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if (visited[nx][ny]) continue;
					if (Math.abs(p.x - nx) + Math.abs(p.y - ny) > D) continue;
					if (temp[nx][ny] == '1') {
						return p2;
					}
					visited[nx][ny] = true;
					q.offer(p2);

				}
			}

			return null;
		}

	}
	static class P {
		int x; int y;

		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}