import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {

	static int N,M,R;	//배열의 행,열 크기와 로테이션 횟수
	static int[][] map;	//배열
	
	// 하 우 상 좌	델타 값
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	//배열의 행크기 입력
		M = Integer.parseInt(st.nextToken());	//배열의 열크기 입력
		R = Integer.parseInt(st.nextToken());	//로테이션 횟수 입력
		
		map = new int[N+1][M+1];	//배열 생성
		
		//배열 정보 입력
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		//회전 수(R) 만큼 반복
		for(int i=0;i<R;i++) {
			rotate();	//전체 1 회전
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	//전체 1회전 메소드
	private static void rotate() {
		int round = Math.min(N, M) / 2;
		for (int s = 1; s <= round; s++) {
			int dir = 0;
			int x = s;
			int y = s;
			int temp = map[x][y];
			int temp2 = 0;
			while (true) {
				// 껍데기에서 회전시키기
				// TODO 방향전환, 이전 원소와 SWAP
				if (dir >= 4) {
					break;
				}
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx < s || nx > N-s+1 || ny < s || ny > M-s+1) {
					dir++;
					continue;
				}
				//실제 이동
				x += dx[dir];
				y += dy[dir];

				//값 변경 작업
				temp2 = map[x][y];	//이동한 값 temp에 받아놓기
				map[x][y] = temp;
				temp = temp2;

			}

		}
	}
}