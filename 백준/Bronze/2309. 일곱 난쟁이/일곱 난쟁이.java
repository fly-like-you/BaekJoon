

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dwarfs;
    static boolean[] visited;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9;
        dwarfs = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarfs);
//        dwarfs = new int[]{20, 7, 23, 19, 10, 15, 25, 8, 13};
        dfs(0);
    }

    private static void dfs(int depth) {

        if (depth == 7) {
//            System.out.println(Arrays.toString(visited));
            sb = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sb.append(dwarfs[i] + " ");
                    sum += dwarfs[i];
                }
            }

            if (sum == 100) {
                System.out.println(sb);
                System.exit(0);

            }
        } else {
            for (int i = depth; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }


    }
}

