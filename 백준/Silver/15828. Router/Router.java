import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/*
모든 정보는 발생한 시간순으로 주어졌다고 가정한다.
양의 정수는 해당하는 번호의 패킷이 입력으로 들어왔다는 것을 의미하고,
0은 라우터가 패킷 하나를 처리했다는 것을 의미한다.
이때, 버퍼가 비어있을때는 0이 입력으로 들어오지 않는다. -1은 입력의 끝을 나타낸다.
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
         q = new ArrayDeque<>();
        while (true) {
            int task = Integer.parseInt(br.readLine());
            switch (task) {
                case 0:
                    q.poll();
                    break;
                case -1:
                    print(q);
                    return;
                default:
                    if (q.size() > N) continue;
                    q.offer(task);
            }
        }
    }

    private static void print(Queue<Integer> q) {
        Iterator<Integer> iterator = q.iterator();
        StringBuilder sb = new StringBuilder();

        while (iterator.hasNext()) {
            sb.append(iterator.next() + " ");
        }

        System.out.println(sb);
    }
}
/*
5
1
2
0
3
4
0
5
6
0
0
-1
 */