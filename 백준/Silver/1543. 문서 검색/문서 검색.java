import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // 엣지 케이스
        // 0번 등장할 때 0번
        // 0이 2500자 등장하고 찾고 싶은 단어가 0일 때 2500

        String document = br.readLine();
        String target = br.readLine();
        int answer = 0;

        // 시간 복잡도 O(NM) 풀이
        int i = 0;
        while (true) {
            boolean flag = true;
            if (i > document.length() - target.length()) break;

            for (int j = 0; j < target.length(); j++) {
                // 찾는 문자열과 일치하는지 하나하나 확인하기
                char c = document.charAt(i + j);
                char t = target.charAt(j);
                if (c != t) flag = false;
            }
            if (!flag) {
                i++;
            } else {
                i = i + target.length();
                answer++;
            }
        }


        System.out.println(answer);

    }
}
