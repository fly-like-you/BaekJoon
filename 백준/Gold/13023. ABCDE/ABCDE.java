import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 5 4
 0 1
 1 2
 2 3
 3 4
 */

public class Main {
    // 백트래킹을 통해서 탐색 깊이가 5인 그래프 찾아내기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int R;
    static List<List<Integer>> relations;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 친구 수
        M = Integer.parseInt(st.nextToken());  // 관계 수
        visited = new boolean[N+1];
        R = 5;
        relations = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            relations.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
            relations.get(to).add(from);
        }

        for (int i = 0; i <= N; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            solution(1, i);
        }
        System.out.println(0);
    }

    private static void solution(int depth, int cur) {
        if (depth == R) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 0; i < relations.get(cur).size(); i++) {
            Integer node = relations.get(cur).get(i);
            if (visited[node]) continue;
            visited[node] = true;
            solution(depth + 1, node);
            visited[node] = false;
        }
    }
}