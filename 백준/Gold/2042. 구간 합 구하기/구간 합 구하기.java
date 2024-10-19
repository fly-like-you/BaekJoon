import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int SIZE = 1 << 20, leaf = 1 << 19;
    static int N, M, K;
    static long answer;
    static long[] tree;
    /*
    5 2 2
    1
    2
    3
    4
    5
    1 3 6
    2 2 5
    1 5 2
    2 3 5
     */
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        leaf = 1;
        while (leaf < N) {
            leaf <<= 1;
        }
        tree = new long[leaf * 2];
        makeTree();
        // tree의 크기는 N의 크기 * 2
        // 1, 3, 7,
        // 1은 업데이트 2는 겟
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                long c = Long.parseLong(st.nextToken());
                update(b, c);
            } else {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                System.out.println(get(1, 0, leaf - 1, b, c));
            }
        }


    }
    private static void update(int idx, long value) {
        // 값이 바뀌면?
        // 노드의 위치만 바꿔주고
        int index = leaf + idx;
        tree[index] = value;

        index /= 2;
        // 해당 위치에서 루트노드까지 이동하면서 누적합을 업데이트한다.
        while (index >= 1) {
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
            index = index / 2;
        }
    }

    private static long get(int index, int s, int e, int ts, int te) {
        // 1. 시작 위치와 종료 위치가 완전 일치할 때
        if (ts <= s && e <= te) return tree[index];
        else if (s > te || e < ts) return 0;
        // 2. 아예 겹치지 않을 때

        int mid = (s + e) / 2;
        long l = get(index * 2, s, mid, ts, te);
        long r = get(index * 2 + 1, mid + 1, e, ts, te);
        // 3. 일부만 겹칠 때
        return l + r;
    }
    private static void makeTree() throws IOException {
        // 포화이진트리로 만들기 위해서 2의 제곱수에 해당하는 수를 만들기 10이면 16으로 잡은 뒤 32
        // 100만 이니까
        for (int i = 0; i < N; i++) {
            tree[leaf + i] = Long.parseLong(br.readLine());
        }

        for (int i = leaf - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }



}