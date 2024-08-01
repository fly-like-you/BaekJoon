import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        back_tracking(0);

        System.out.println(cnt);
    }

    static void back_tracking(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (board[depth][i] != 0) {
                continue;
            }

            ChessUpdate(depth, i, 1);
            back_tracking(depth + 1);
            ChessUpdate(depth, i, -1);
        }
    }

    static void ChessUpdate(int row, int col, int option) {
        for (int i = 0; i < N; i++) {
            board[i][col] += option;
            board[row][col] += option;
        }

        for (int x = row, y = col; isOnBoard(x, y); x++, y++) {
            board[x][y] += option;
        }
        for (int x = row, y = col; isOnBoard(x, y); x++, y--) {
            board[x][y] += option;
        }
        for (int x = row, y = col; isOnBoard(x, y); x--, y++) {
            board[x][y] += option;
        }
        for (int x = row, y = col; isOnBoard(x, y); x--, y--) {
            board[x][y] += option;
        }

        board[row][col] -= option * 5;
    }

    static boolean isOnBoard(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N ? true : false;
    }
}