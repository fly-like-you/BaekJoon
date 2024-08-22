import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(arr[0]);
            System.exit(0);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int price = 0;
        for (int i = 0; i < N; i++) {
            if (i % 3 == 2) continue;
            price += arr[i];
        }
        System.out.println(price);
    }
}