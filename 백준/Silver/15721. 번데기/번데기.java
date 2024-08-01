import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int T;
    static String word;
    static int answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        // 0이면 뻔 1이면 데기
        word = br.readLine();

        int loop = 1;
        int start = 0;
        // T 구하기
        while (true) {
            T -= 4 + (loop-1);
            if (T <= 0) {
                T += 4 + (loop-1);
                break;
            }
            start = ((2 * loop) + 6 + start) % N;
            loop++;
        }
        // T 번째 데기 또는 뻔을 외친사람 찾기
        String sentence = "0101" + "0".repeat(loop + 1) + "1".repeat(loop + 1);
        int cnt = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == word.charAt(0)) {
                cnt++;

                if (T == 0) {
                    System.out.println((i+start) % N);
                    
                    return;
                } else if (cnt == T) {
                    System.out.println((i+start) % N);
                    return;
                }
            }
        }

    }
}