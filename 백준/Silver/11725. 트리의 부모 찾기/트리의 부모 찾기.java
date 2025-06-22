import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 그래프 초기화
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        // BFS
        boolean[] visited = new boolean[N + 1];
        int[] answer = new int[N + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> neighbor = list.get(node);
            for (Integer i : neighbor) {
                if (visited[i]) continue;

                answer[i] = node;
                queue.add(i);
                visited[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}
