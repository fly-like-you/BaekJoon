import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
//2번
class Main {
    static int answer;
    static int N;
    static int K;
    static int[] arr;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        answer = Integer.MAX_VALUE;
        A: for (int i=1;i<=1000;i++){
            int tmp = 0;
            int start = i;
            if (arr[0] != start) tmp++;
            for (int j=1;j<N;j++){
                start += K;
                if (arr[j] != start) tmp++;
            }
            answer = Math.min(answer, tmp);
//            System.out.println(tmp);
        }
        System.out.println(answer);
    }
}