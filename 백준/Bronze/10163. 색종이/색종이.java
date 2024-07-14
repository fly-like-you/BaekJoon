import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static byte[][] paper;
    static int [] colorPaper;
    public static void main(String[] args) throws IOException {
        // (왼쪽아래 좌표), (너비), (높이)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = 1001;
        colorPaper = new int[N+1];
        Arrays.fill(colorPaper, 0);
        StringTokenizer st;
        paper = new byte[M][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(paper[i], (byte) 0);
        }


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for (int j = x; j < x+width; j++) {
                for (int k = y; k < y+height; k++) {
                    paper[j][k] = (byte) i;
                }
            }
        }
        solution();
        for (int i = 1; i <= N; i++) {
            System.out.println(colorPaper[i]);
        }
    }
    public static void solution(){
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                colorPaper[paper[i][j]]++;
            }
        }
    }
}