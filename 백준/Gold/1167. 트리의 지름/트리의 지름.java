import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
    int num, dist;
    public Pair(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int MAX_N = 100_000;
    static ArrayList<Pair>[] edges = new ArrayList[MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {

                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int w = Integer.parseInt(st.nextToken());
                edges[from].add(new Pair(to, w));
                edges[to].add(new Pair(from, w));
            }


        }
        int fVertex = FindLargestVertex(1).num;

        int diameter = FindLargestVertex(fVertex).dist;

        System.out.println(diameter);


    }

    // 정점 x로부터 가장 멀리 있는 정점 정보 찾기
    private static Pair FindLargestVertex(int x) {
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
            dist[i] = 0;
        }

        visited[x] = true;
        dist[x] = 0;
        dfs(x, 0);

        int farthestDist = -1;
        int farthestVertext = -1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > farthestDist) {
                farthestDist = dist[i];
                farthestVertext = i;
            }
        }

        return new Pair(farthestVertext, farthestDist);
    }

    private static void dfs(int x, int totalDist) {
        for (int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i).num;
            int d = edges[x].get(i).dist;

            if (visited[y]) continue;
            visited[y] = true;
            dist[y] = totalDist + d;
            dfs(y, totalDist + d);
        }
    }
}