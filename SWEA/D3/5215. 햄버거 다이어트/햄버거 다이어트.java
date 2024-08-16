import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	static int N;
	static int L;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			System.out.println("#" + test + " " + solution());
		}
		
	}

	private static int solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		maxTaste = 0;
		tastes = new int[N];
		kals = new int[N];


		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			tastes[i] = Integer.parseInt(st.nextToken());
			kals[i] = Integer.parseInt(st.nextToken());
		}

		subset(0, 0, 0);
		return maxTaste;
	}

	static int maxTaste;
	static int[] tastes;
	static int[] kals;
	private static void subset(int depth, int kcalSum, int tasteSum) {
		if (depth == N) {
			if (kcalSum <= L) {
				maxTaste = Math.max(tasteSum, maxTaste);
			}
			return;
		}

		subset(depth + 1, kcalSum + kals[depth], tasteSum + tastes[depth]);
		subset(depth + 1, kcalSum, tasteSum);
	}
	
}