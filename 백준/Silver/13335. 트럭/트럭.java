import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int time = 0;
    static Queue<Integer> bridge = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedList<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        bridge.add(trucks.poll());
        time++;
        while (!trucks.isEmpty() && !bridge.isEmpty()) {

            if (bridge.size() != W) {
                // 넣기
                if (queueSum() + trucks.peek() > L) {
                    bridge.add(0);
                } else {
                    bridge.add(trucks.poll());
                }
            } else {
                // 하나 꺼내고 넣기
                bridge.poll();
                if (queueSum() + trucks.peek() > L) {
                    bridge.add(0);
                } else {
                    bridge.add(trucks.poll());
                }
            }
            time++;
        }
        System.out.println(time + W);
    }

    static int queueSum() {
        int sum = 0;
        for (int v : bridge) {
            sum += v;
        }
        return sum;
    }

}