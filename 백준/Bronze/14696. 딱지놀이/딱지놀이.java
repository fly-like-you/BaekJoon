import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Integer[] a;
    static Integer[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A: for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int aLen = Integer.parseInt(st.nextToken());
            a = new Integer[aLen];
            for (int j = 0; j < aLen; j++) {
                int card = Integer.parseInt(st.nextToken());
                a[j] = card;
            }
            st = new StringTokenizer(br.readLine());
            int bLen = Integer.parseInt(st.nextToken());
            b = new Integer[bLen];
            for (int j = 0; j < bLen; j++) {
                int card = Integer.parseInt(st.nextToken());
                b[j] = card;
            }
            Arrays.sort(a, Collections.reverseOrder());
            Arrays.sort(b, Collections.reverseOrder());
            int minLen = Math.min(aLen, bLen);
            for (int j = 0; j < minLen; j++) {
                if (a[j] < b[j]) {
                    System.out.println("B");
                    continue A;
                } else if (a[j] > b[j]) {
                    System.out.println("A");
                    continue A;
                }
            }
            if (aLen < bLen) {
                System.out.println("B");
            } else if (aLen == bLen) {
                System.out.println("D");
            } else {
                System.out.println("A");
            }

        }

    }

}