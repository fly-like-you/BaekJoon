import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] wBoard = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
    static String[] bBoard = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        int min_count = Integer.MAX_VALUE;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                String[] sliceString = slice2D(board, i, i + 8, j, j + 8);
                min_count = Math.min(solution(sliceString), min_count);

            }
        }
        System.out.println(min_count);
    }
    public static String[] slice2D(String[] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        String[] result = new String[rowEnd - rowStart];
        for (int i = rowStart; i < rowEnd; i++) {
            result[i - rowStart] = array[i].substring(colStart, colEnd);
        }
        return result;
    }


    public static int solution(String[] chess) {
        int bCount = 0;
        int wCount = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length(); j++) {
                if (chess[i].charAt(j) != bBoard[i].charAt(j)) {
                    bCount += 1;
                }
            }
        }
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length(); j++) {
                if (chess[i].charAt(j) != wBoard[i].charAt(j)) {
                    wCount += 1;
                }
            }
        }
        return Math.min(bCount, wCount);
    }
}
