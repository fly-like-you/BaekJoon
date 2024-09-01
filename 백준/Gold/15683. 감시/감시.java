import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**

 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][] office;
	static ArrayList<CAM> cams;
	static int maxWatch = 0;


	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new int[N][M];
		cams = new ArrayList<>();
		int remains = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int o = Integer.parseInt(st.nextToken());
				office[i][j] = o;
				if (o != 0 && o != 6) {
					cams.add(new CAM(i, j, o-1));
				}
				if (o == 0) {
					remains++;
				}
			}
		}
		solution(0, 0);
		System.out.println(remains - maxWatch);

	}
	// CCTV를 쐈다가 다시 돌려놓는 방법
	// 모든 CCTV를 저장해두고 마지막에 세보는 방법
	private static void solution(int depth, int remains) {
//		if (remains < maxWatch) return;
		if (depth == cams.size()) {
			maxWatch = Math.max(maxWatch, remains);
			return;
		}

		CAM cam = cams.get(depth);
		for (int i = 0; i < cam.rotateCnt; i++) {
			int[][] temp = copy();
			int watch = cam.watch(office);
			solution(depth + 1, remains + watch); // 감시한 구역
			office = temp;
		}
	}


	private static int[][] copy() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = office[i][j];
			}
		}
		return temp;
	}


	// 카메라의 번호별로 회전할 방향을 결정하는 배열
	// 인덱스 번호 -> 카메라의 번호
	// 원솟값 -> 감시 방향
	// 배열의 길이 -> 회전 횟수
	static int[][][] rotatedir = {
			{{0},		{1},		{2},		{3}},
			{{0, 2},	{1, 3}},
			{{3, 0},	{0, 1}, 	{1, 2},	 	{2, 3}},
			{{2, 3, 0},	{0, 1, 3}, {0, 1, 2},	{1, 2, 3}},
			{{0, 1, 2, 3}},
	};
	static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
	static int[] dy = {1, 0, -1, 0};

	static class CAM {
		int x, y;
		int camNum;
		int rotateCnt;
		int curDir; // 0, 1, 2, 3, 4

		public CAM(int x, int y, int camNum) {
			this.x = x;
			this.y = y;
			this.camNum = camNum;
			rotateCnt = rotatedir[camNum].length; // 도는 횟수
			// 카피해주기
			curDir = 0;
		}
		public int watch(int[][] map) {
			// curDir로 자신의 위치를 감시
			// 감시하고 남은 0의 자리를 세보기
			int watch = 0;
			int[] d = rotatedir[camNum][curDir]; // 현재 자신이 탐색해야하는 위치
			for (int i = 0; i < d.length; i++) {
				// 방향 설정 현재 방향에 맞게 위치를 결정하기
				int nx = x + dx[d[i]];
				int ny = y + dy[d[i]];

				// 자신의 다음 좌표부터 맵의 끝까지 탐색하기
				while (true) {
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if (map[nx][ny] == 6) break;
					if (map[nx][ny] == 0) {
						map[nx][ny] = -1;
						watch++;
					}

					nx += dx[d[i]];
					ny += dy[d[i]];
				}
			}


			// 자신의 dir을 업데이트
			curDir++;
			if (curDir == rotatedir[camNum].length) curDir = 0;
			return watch;
		}
	}
}