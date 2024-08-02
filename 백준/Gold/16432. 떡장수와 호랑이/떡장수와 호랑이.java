import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static int N; // 배열의 크기
    static int[] answer;


    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        answer = new int[N];
        visited = new boolean[N][];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            arr[i] = temp;
            visited[i] = new boolean[m];
        }

        dfs(0, 0);
        System.out.println(-1);
    }

    private static void dfs(int depth, int node) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.println(answer[i]);
            }
            System.exit(0);
        }
        for (int i = 0; i < arr[depth].length; i++) {
            if (!visited[depth][i] && arr[depth][i] != node) {
                answer[depth] = arr[depth][i];
                visited[depth][i] = true;
                dfs(depth + 1, arr[depth][i]);
            }

        }
    }
}