import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        A: while (true) {
            String word = br.readLine();
            if (word.equals("#")) break;

            char[] wordArr = word.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char mirrorWord = wordArr[i];
                if (mirrorWord == 'b') {
                    wordArr[i] = 'd';
                } else if (mirrorWord == 'd') {
                    wordArr[i] = 'b';
                } else if (mirrorWord == 'p') {
                    wordArr[i] = 'q';
                } else if (mirrorWord == 'q') {
                    wordArr[i] = 'p';
                } else if (mirrorWord != 'i' && mirrorWord != 'o' && mirrorWord != 'v' && mirrorWord != 'w'
                        && mirrorWord != 'x') {
                    System.out.println("INVALID");
                    continue A;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = wordArr.length-1; i >= 0; i--) {
                sb.append(wordArr[i]);
            }
            System.out.println(sb);
        }
    }
}

