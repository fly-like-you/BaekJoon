import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    static int answer;
    static int N;

    public static void main(String[] args) throws IOException {
        arr = br.readLine().toCharArray();
        N = arr.length;
        Arrays.sort(arr);

        A: do {
            for (int i = 1; i < N-1; i++) {
                if (arr[i] == arr[i + 1] || arr[i] == arr[i - 1]) {
                    continue A;
                }
            }
            answer++;

        } while (np());
        System.out.println(answer);
    }

    private static boolean isValid() {

        return false;
    }
    static boolean np() {
        // 꼭짓점 i를 찾는다.
        int i = N - 1;
        while (i>0 && arr[i-1] >= arr[i]) i--;
        if (i == 0) return false;

        // i ~ N-1까지 i-1보다 크지만 제일 작은 인덱스 j를 찾는다.
        int j = N - 1;
        while (arr[i-1] >= arr[j]) j--;

        // j와 i-1을 swap
        swap(j, i - 1);

        // i ~ N-1 까지 오름차순 정렬
        int k = N - 1;
        while (k > i) {
            swap(k--, i++);
        }

        return true;
    }
    private static void swap(int p1, int p2) {
        char temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}