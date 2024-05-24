import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        solution(size, r, c);
        System.out.println(count);
    }

    public static void solution(int size, int r, int c) { // size는 변의 길이
        if (size == 1) {
            return;
        }

        if (r < size / 2 && c < size / 2) {
            solution(size / 2, r, c);
        }
        if (r < size / 2 && c >= size / 2) {
            count += size * size / 4;
            solution(size / 2, r, c - size / 2);
        }
        if (r >= size / 2 && c < size / 2) {
            count += (size * size / 4) * 2;
            solution(size / 2, r - size / 2, c);
        }
        if (r >= size / 2 && c >= size / 2) {
            count += (size * size / 4) * 3;
            solution(size / 2, r - size / 2, c - size / 2);
        }
    }
}