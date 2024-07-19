import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int T;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int carPrice = Integer.parseInt(br.readLine());
            int optionPrices = 0;
            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int cnt = Integer.parseInt(st.nextToken());
                int optPrice = Integer.parseInt(st.nextToken());
                optionPrices += optPrice * cnt;

            }
            System.out.println(carPrice + optionPrices);
        }

    }
}