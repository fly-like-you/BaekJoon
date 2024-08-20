import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//5
//2 2
//3 4
//5 6
//1 9
//-2 -8
public class Main {
    static int N;
    static int[] x;
    static int[] y;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        x = new int[N];
        y = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);
        int[] store = {x[N / 2], y[N / 2]};

        long distance = 0;

        for (int j = 0; j < N; j++) {
            distance += Math.abs(store[0] - x[j]) + Math.abs(store[1] - y[j]);
        }
        System.out.println(distance);
    }
}