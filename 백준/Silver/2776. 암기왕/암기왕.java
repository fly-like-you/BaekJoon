import java.util.*;
import java.lang.*;
import java.io.*;
 
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int check = Integer.parseInt(st.nextToken());
				if (Arrays.binarySearch(arr, check) >= 0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
}