import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[] words;
    static String code;

    public static void main(String[] args) throws IOException {
        code = br.readLine();
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 1에서 26까지 암호문에 대해서 한칸씩 밀어보기
        for (int i = 0; i < 26; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < code.length(); j++) {
                char nextCode = (char) (((code.charAt(j) + i) % 26) + 'a');
                sb.append(nextCode);
            }

            for (int j = 0; j < N; j++) {
                if (sb.toString().contains(words[j])) {
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}
/*
srbvaffefeczevaluxv
3
bake
bread
cookie
 */