import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solution();
    }

    private static void solution() {
        int maxCount = 0;
        int maxInt = 0;
        for (int i = 1; i <= N; i++) {
            int count = calc(i);
            if (maxCount < count) {
                maxCount = count;
                maxInt = i;
            }
        }
        System.out.println(maxCount);
        calcPrint(maxInt);
    }

    private static int calc(int i) {
        int count = 2;
        int elem1 = N;
        int elem2 = i;

        while (true) {
            int nextElem = elem1 - elem2;
            if (nextElem < 0) {
                break;
            }
            count++;
            elem1 = elem2;
            elem2 = nextElem;
        }
        return count;
    }

    private static void calcPrint(int i) {
        int elem1 = N;
        int elem2 = i;
        StringBuilder sb = new StringBuilder(N + " " + i + " ");
        while (true) {
            int nextElem = elem1 - elem2;
            if (nextElem < 0) {
                break;
            }
            elem1 = elem2;
            elem2 = nextElem;
            sb.append(nextElem + " ");
        }
        System.out.println(sb);
    }

}