import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    static int S;
    static class Node {
         int clipboard;
         int cur;
         int time;

        public Node(int clipboard, int cur, int time) {
            this.clipboard = clipboard;
            this.cur = cur;
            this.time = time;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[1001][1001];
        Node node = new Node(0, 1, 0);
        visited[0][1] = true;
        q.offer(node);
        while (!q.isEmpty()) {
            Node n = q.poll();

            // 복사
            if (n.clipboard != n.cur && !visited[n.cur][n.cur]) {
                Node copyNode = new Node(n.cur, n.cur, n.time + 1);
                visited[n.cur][n.cur] = true;
                q.offer(copyNode);
            }


            // 붙여넣기
            if (n.cur + n.clipboard == S) {
                System.out.println(n.time + 1);
                return;
            }
            Node pasteNode = new Node(n.clipboard, n.cur + n.clipboard, n.time + 1);
            if (pasteNode.cur <= 1000 && !visited[pasteNode.clipboard][pasteNode.cur]) {
                visited[pasteNode.clipboard][pasteNode.cur] = true;
                q.offer(pasteNode);
            }

            // 하나빼기
            if (n.cur - 1 == S) {
                System.out.println(n.time + 1);
                return;
            }
            Node subNode = new Node(n.clipboard, n.cur - 1, n.time + 1);
            if (subNode.clipboard >= 0 && subNode.cur >= 0 && !visited[subNode.clipboard][subNode.cur]) {
                visited[subNode.clipboard][subNode.cur] = true;
                q.offer(subNode);
            }
        }
    }
}