import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N = 9;
    static char[][] arr;
    
    // r, c에 따라서 몇번째 칸인지 나오도록 하는 배열
    // 1, 1 이면 0번째 칸이고 나오는 값은 (0, 0), (2, 2)
    static int[][] blocks =
    	{
    			{0, 0}, {0, 3}, {0, 6},
    			{3, 0}, {3, 3}, {3, 6},
    			{6, 0}, {6, 3}, {6, 6},
    	};
    public static void main(String[] args) throws IOException {
    	arr = new char[N][N];
    	
    	for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray(); 
		}
    	
    	solution(0);
    }
    
    /**
     * @solution: 
     * 3, 4, 5가 가능하다면?
     */
    private static void solution(int depth) {
    	int r = depth / N;
    	int c = depth % N;
    	if (depth == N * N) {
    		for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
    		System.exit(0);
    	}
    	if (arr[r][c] != '0') {
            solution(depth + 1);
            return;
        }
           
    	
    	// 1. 후보를 고르기
    	boolean[] set = findCandidate(r, c);

    	
    	// 2. 후보에 대해서 값을 넣은 뒤 다음으로 넘기기
    	for (int i = 1; i <= N; i++) {
			if (set[i]) continue;
			arr[r][c] = Character.forDigit(i, 10);
			solution(depth + 1);
			arr[r][c] = '0';
		}
    	
    }

	private static boolean[] findCandidate(int r, int c) {
		boolean[] set = new boolean[N + 1];
		// 행에 대해서 탐색
		for (int i = 0; i < N; i++) {
			if (arr[i][c] == '0') continue;
			set[arr[i][c] - '0'] = true;
		}
		// 열에 대해서 탐색
		for (int j = 0; j < N; j++) {
			if (arr[r][j] == '0') continue;
			set[arr[r][j] - '0'] = true;
		}
		
		// 3 * 3칸에 대해서 탐색
		A: for (int i = 0; i < N; i++) {
			int s = blocks[i][0];
			int e = blocks[i][1];
			if (r >= s && r < s + 3 && c >= e && c < e + 3) {
				for (int j = s; j < s + 3; j++) {
					for (int k = e; k < e + 3; k++) {
						if (arr[j][k] == '0') continue;
						set[arr[j][k] - '0'] = true;
					}
				}
				break A;
			}
		}
		return set;
	}
}
/*
103 000 509
002 109 400
000 704 000

300 502 006
060 000 050
700 803 004

000 401 000
009 205 800
804 000 107
*/