import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[6][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            arr[grade - 1][gender]++;
        }
        int roomCount = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                double room = Math.ceil((double) arr[i][j] / (double) K);
                roomCount += room;
            }
        }
        System.out.println(roomCount);
    }
}