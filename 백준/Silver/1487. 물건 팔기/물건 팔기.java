import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static Customer[] customers;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        customers = new Customer[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            customers[i] = new Customer(price, fee);
        }

        Arrays.sort(customers, (c1, c2) -> c1.price - c2.price);

        int benefitPrice = 0;
        int highMargin = 0;
        for (int i = 0; i < N; i++) {
            int margin = 0;
            int p = customers[i].price;

            for (int j = i; j < N; j++) {
                int benefit = p - customers[j].fee;
                if (benefit > 0) {
                    margin += benefit;
                }

            }
            if (margin > highMargin) {
                highMargin = margin;
                benefitPrice = p;
            }
        }
        System.out.println(benefitPrice);

    }


    static class Customer {
        int price;
        int fee;

        public Customer(int price, int fee) {
            this.price = price;
            this.fee = fee;
        }

    }
}