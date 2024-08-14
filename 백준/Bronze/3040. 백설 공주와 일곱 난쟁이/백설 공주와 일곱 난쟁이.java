/**
 * 메모리 : 14204
 * 실행 시간 : 96
 * 2개를 골라서 sum-100 만들기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
		static int[] dwarfs;
		static int[] fakes;
		static boolean[] visited;
		static int N = 9;
		static int R = 2;
		static int total;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			dwarfs = new int[N];
			fakes = new int[N-R];
			for (int i = 0; i < N; i++) {
				int height = Integer.parseInt(br.readLine());
				dwarfs[i] = height;
				total += height;
			}

			solution(0, 0, 0);

		}

		private static void solution(int depth, int prev, int heightSum) {
			if (depth == R) {
				if (total - heightSum == 100) {
					for (int i = 0; i < N; i++) {
						if (i != fakes[0] && i != fakes[1]) {
							System.out.println(dwarfs[i]);
						}
					}
					System.exit(0);
				}
				return;
			}

			for (int i = prev; i < N; i++) {
				fakes[depth] = i;
				solution(depth+1, i+1, heightSum + dwarfs[fakes[depth]]);
			}
		}

	}