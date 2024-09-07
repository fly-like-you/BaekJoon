import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 메모리:KB, 시간:ms
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int K, W, H;
	static int[][][] visited;
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		visited = new int[K+1][H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}

		}

		bfs(0, 0);
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			if (visited[i][H-1][W-1] != 0) {

				answer = Math.min(answer, visited[i][H-1][W-1]);
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer-1);
//		System.out.println(visited[0][H-1][W-1]);
//		System.out.println(visited[1][H-1][W-1]);
		
	}
	private static void print(int flag) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(visited[flag][i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int[] dx = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1 ,-1};
	static int[] dy = {0, 0, 1, -1, 1, 2, 2, 1, -1, -2, -2, -1};

	
	// [K] 번 사용
	static Queue<int[]> q = new ArrayDeque<>();
	private static void bfs(int sx, int sy) {
		for (int i = 0; i <= K; i++) {
			q.offer(new int[] {sx, sy, 0});
			visited[i][sx][sy] = 1;
		}

		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			int k = node[2];
			for (int i = 0; i < 12; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W ) {
                    continue;
                }

                if (map[nx][ny] == '1') {
                    continue;
                }
				
				if (i < 4) { // 일반 이동
					// 다음 탐색 좌표가 0이거나 현재값보다 크다면 탐색
					if (visited[k][nx][ny] == 0) {
						visited[k][nx][ny] = visited[k][x][y] + 1;
						q.offer(new int[] {nx, ny, k});
					}
				} else { // 나이트 이동
					// K값을 모두 소진했으면 이번하지못함
					if (k < K) {
						if (visited[k+1][nx][ny] == 0) {
							visited[k + 1][nx][ny] = visited[k][x][y] + 1;
							q.offer(new int[]{nx, ny, k + 1});
						}
					}
				}
			}
		}
		
	}
}
/*
2
10 2
0 0 1 0 0 1 0 0 1 0
0 0 1 1 0 0 0 0 1 0
1
5 2
0 0 0 1 0
0 0 0 1 0
*/