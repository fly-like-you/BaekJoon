/**
*
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int N,M;
	static int cur[];
	static void dfs(int depth, int last) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(cur[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = last; i <= N; i++) {
			cur[depth] = i;
			dfs(depth+1, i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cur = new int[M];
		sb = new StringBuilder();
		dfs(0, 1);
		System.out.print(sb);
	}


}