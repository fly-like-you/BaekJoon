/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static String cmd;
	static int[][] grid;
	static StringBuilder sb = new StringBuilder();
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			grid = new int[N][N];
			cmd = st.nextToken();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			sb.append("#").append(t).append("\n");
			solution();
			print();

		}
		System.out.println(sb);
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(grid[i][j] + " ");
			}
			sb.append("\n");
		}
	}
	private static void solution() {
		switch(cmd) {
		case "down" :
			// 위 -> 아래
			// 오른쪽 -> 왼쪽
			for(int y = 0; y < N; y++) {
				int k = N-1;
				for(int x = N-1; x >= 0; x--) {
					// 밀기
					if (grid[x][y] != 0) {
						grid[k--][y] = grid[x][y];
					}

				}
				for (int i = k; i >= 0; i--) {
					grid[i][y] = 0;
				}

				// 합치기
				for (int x = N-1; x > 0; x--) {
					if (grid[x][y] == grid[x-1][y]) {
						grid[x][y] *= 2;
						grid[x-1][y] = 0;
					}

				}
				k = N-1;
				for(int x = N-1; x >= 0; x--) {
					// 밀기
					if (grid[x][y] != 0) {
						grid[k--][y] = grid[x][y];
					}

				}
				for (int i = k; i >= 0; i--) {
					grid[i][y] = 0;
				}
			}
			break;
		case "up" :
			// 아래 -> 위
			// 오른쪽 -> 왼쪽
			for(int y = 0; y < N; y++) {
				int k = 0;
				for (int x = 0; x < N; x++) {
					// 밀기
					if (grid[x][y] != 0) {
						grid[k++][y] = grid[x][y];
					}

				}
				for (int i = k; i < N; i++) {
					grid[i][y] = 0;
				}
				
				// 합치기
				for (int x = 0; x < N-1; x++) {
					if (grid[x][y] == grid[x+1][y]) {
						grid[x][y] *= 2;
						grid[x+1][y] = 0;
					}

				}
				k = 0;
				for (int x = 0; x < N; x++) {
					// 밀기
					if (grid[x][y] != 0) {
						grid[k++][y] = grid[x][y];
					}

				}
				for (int i = k; i < N; i++) {
					grid[i][y] = 0;
				}
			}
			
			break;
		case "right" :
			// 위에서부터 아래로
			// 왼쪽에서부터 오른쪽으로
			for(int x = 0; x < N; x++) {
				int k = N-1;
				// 밀기
				for(int y = N-1; y >= 0; y--) {
					if (grid[x][y] != 0) {
						grid[x][k--] = grid[x][y];
					}

				}
				for (int i = k; i >= 0; i--) {
					grid[x][i] = 0;
				}
				
				// 합치기
				for(int y = N-1; y > 0; y--) {
					if (grid[x][y] == grid[x][y-1]) {
						grid[x][y] *= 2;
						grid[x][y-1] = 0;
					}

				}
				// 밀기
				k = N-1;
				for(int y = N-1; y >= 0; y--) {
					if (grid[x][y] != 0) {
						grid[x][k--] = grid[x][y];
					}

				}
				for (int i = k; i >= 0; i--) {
					grid[x][i] = 0;
				}
			}
			break;
			
		case "left" :
			// 위 -> 아래
			// 오른쪽 -> 왼쪽
			for (int x = 0; x < N; x++) {
				int k = 0;
				for (int y = 0; y < N; y++) {
					// 밀기
					if (grid[x][y] != 0) {
						grid[x][k++] = grid[x][y];
					}

				}
				for (int i = k; i < N; i++) {
					grid[x][i] = 0;
				}
				
				// 합치기
				for (int y = 0; y < N-1; y++) {
					if (grid[x][y] == grid[x][y+1]) {
						grid[x][y] *= 2;
						grid[x][y+1] = 0;
					}

				}
				k = 0;
				for (int y = 0; y < N; y++) {
					// 밀기
					if (grid[x][y] != 0) {
						grid[x][k++] = grid[x][y];
					}

				}
				for (int i = k; i < N; i++) {
					grid[x][i] = 0;
				}
			}
			break;
		}
	}
}
//1
//5 left
//4 8 2 4 0
//4 4 2 0 8
//8 0 2 4 4
//2 2 2 2 8
//0 2 2 0 0