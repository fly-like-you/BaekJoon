import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] ducks;
    static int[] quack;
    public static void main(String[] args) throws IOException {
        ducks = br.readLine().toCharArray();
        int N = ducks.length;
        quack = new int[5];
        int maxDuck = 0;
        for (int i = 0; i < N; i++) {
            char crying = ducks[i];
            int idx = mapping(crying);
            quack[idx]++;
            if (!ruleCkeck(idx)) return;
            if (idx == 4) {
                maxDuck = Math.max(quack[0] - quack[4], maxDuck);
            }


        }
        int crying = quack[0];
        for (int i = 0; i < 5; i++) {
            if (crying != quack[i]){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(maxDuck + 1);
    }
    static boolean ruleCkeck(int idx) {
        for (int j = 0; j <= idx; j++) {
            if (quack[j] < 0 || quack[j] < quack[idx]) {
                System.out.println(-1);
                return false;
            }
        }
        return true;
    }
    static int mapping(char crying) {
        switch (crying) {
            case 'q':
                return 0;
            case 'u':
                return 1;
            case 'a':
                return 2;
            case 'c':
                return 3;
            case 'k':
                return 4;
        }
        return -1;
    }
}
/*
quqacukqauackck
qu ac k
  q  u  a  ck
       q ua  ck
q찾기
q 2
u 2
a 1
c 1
k 1
매 루프마다 내림차순을 만족하는지 확인
k 가 추가 될때 배열에 1씩 모두 빼주기 이때 -1인 문자열있으면 -1출력
 */