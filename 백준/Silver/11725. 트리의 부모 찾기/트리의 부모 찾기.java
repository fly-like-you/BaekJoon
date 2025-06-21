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

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 인접 리스트에 노드 추가
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        // Tree 탐색하기
        boolean[] visited = new boolean[N + 1];
        Deque<Integer> q = new ArrayDeque<>();

        // 정답 배열 채우기
        // 시간 복잡도 = O(Nlog N)
        int[] answer = new int[N + 1];
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neighbors = list.get(node);
            for (Integer i : neighbors) {
                if (visited[i]) continue;

                visited[i] = true;
                answer[i] = node;
                q.add(i);
            }
        }

        // 시간 복잡도 = O(N)
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}
