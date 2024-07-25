import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int answer;

    static ArrayList<ArrayList<Integer>> relations;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        relations = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            relations.get(node1).add(node2);
            relations.get(node2).add(node1);
        }

        System.out.println(solution());
    }


    private static int solution() {
        ArrayList<Integer> friends = relations.get(1);
        visited[1] = true;
        for (Integer friend : friends) {
            visited[friend] = true;
            ArrayList<Integer> friendFriend = relations.get(friend);
            for(Integer f : friendFriend) {
                visited[f] = true;
            }
        }

        for (boolean b : visited) {
            if (b) {
                answer++;
            }
        }
        return answer -1;
    }
}