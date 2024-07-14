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
        M = 101;
        N = 5;
        colorPaper = new int[N];
        Arrays.fill(colorPaper, 0);
        StringTokenizer st;
        paper = new byte[M][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(paper[i], (byte) 0);
        }


        for (int i = 1; i <= 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    paper[j][k] = (byte) i;
                }
            }
        }
        solution();
        int answer = 0;
        for (int i = 1; i < N; i++) {
            answer += colorPaper[i];
        }
        System.out.println(answer);
    }
    public static void solution(){
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                colorPaper[paper[i][j]]++;
            }
        }
    }
}