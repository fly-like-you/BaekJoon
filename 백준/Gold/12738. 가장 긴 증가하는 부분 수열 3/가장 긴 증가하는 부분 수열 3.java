import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr, C;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        C = new int[N];
        Arrays.fill(C, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // C[k] : 길이 k의 증가 수열에 대해서 k 번째로 올 수 있는 값들 중 최솟값
        for (int i = 0; i < N; i++) {
            // i = x 일 때 x 앞의
            // C에서 upperbound를 찾은 뒤 그 인덱스에 대해서 i값을 삽입하기
            int idx = upperBound(arr[i]);
            C[idx] = arr[i];
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (C[i] == Integer.MAX_VALUE) continue;
            answer++;
        }
        System.out.println(answer);
    }

    public static int upperBound(int target) {
        int s = 0, e = N-1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (C[mid] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return e;
    }
}

/*
6
10 20 10 30 20 50
 */