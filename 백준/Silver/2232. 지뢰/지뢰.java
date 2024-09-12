import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] mines;
    static boolean[] visited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        mines = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            int v =  Integer.parseInt(br.readLine());
            mines[i] = v;
            pq.offer(new int[]{v, i});
        }


        int bombs = 0;
        List<Integer> answer = new ArrayList<>();
        while (!pq.isEmpty()) {

            int[] mine = pq.poll();
            if (visited[mine[1]]) continue;
            answer.add(mine[1]+1);
            bombs += greedy(mine);
            if (bombs == N) break;
        }

        Collections.sort(answer);
        for (int a : answer) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
    // 그리디 접근
    // 제일 높은 지뢰부터 터트리면서 모든 폭탄이 터질때까지 반복

    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dy = {1, -1};
    private static int greedy(int[] mine) {
        q.clear();
        q.offer(mine);
        visited[mine[1]] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] m = q.poll();
            int power = m[0], idx = m[1];

            for (int i = 0; i < 2; i++) {
                int ny = idx + dy[i];

                if (ny < 0 || ny >= N) continue;
                if (visited[ny]) continue;
                if (mines[ny] >= power) continue;

                visited[ny] = true;
                q.offer(new int[]{mines[ny], ny});
                cnt++;
            }

        }

        return cnt;
    }

}

/*
9
1
2
5
4
3
3
6
6
2
 */