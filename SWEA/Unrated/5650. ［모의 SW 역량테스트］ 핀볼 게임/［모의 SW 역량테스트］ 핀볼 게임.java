import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// 벽에 부딫히면 1점
// 일반 블록: 부딫히는 위치에 따라서 튕기는 방향이 달라짐
// 웜홀 블록: 부딫히면 방향을 일정하게 유지한 채로 짝 웜홀로 이동하게 됨
// 블랙홀: 부딫히면 게임이 끝남

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<int[]>[] wormholes;
    static int T, N, answer;
    static int[][] pinball;
    static int[][] blocks = {
            null,
            {2, 3, 1, 0},	//1번 블록
            {1, 3, 0, 2},	//2번 블록
            {3, 2, 0, 1},	//3번 블록
            {2, 0, 3, 1},	//4번 블록
            {2, 3, 0, 1}	//5번 블록
    };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            wormholes = new ArrayList[5]; // 블록 수에 맞춰 배열 크기 설정
            for (int k = 0; k < 5; k++) {
                wormholes[k] = new ArrayList<>(); // 각 배열 요소에 ArrayList 초기화
            }
            answer = 0;
            pinball = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int block = sc.nextInt();
                    if (block >= 6 && block <= 10) {
                        wormholes[block - 6].add(new int[]{i, j});
                    }
                    pinball[i][j] = block;
                }
            }
            /* 게임 시작 */
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (pinball[i][j] == 0) answer = Math.max(answer, game(i, j, k));
                    }
                }
            }
//            System.out.println(game(0, 0, 0));
            /* 게임 종료 */
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }

    // 상하좌우
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    private static int game(int sx, int sy, int dir) {
        int score = 0;
        int curX = sx, curY = sy;
        int curDir = dir;
        // 핀볼은 어떤 블록을 만날 때까지 방향을 유지한다.
        while (true) {
            curX = curX + dx[curDir];
            curY = curY + dy[curDir];

            if (curX < 0 || curX >= N || curY <0 || curY >= N) {
                curDir = blocks[5][curDir];
                score++;
                continue;
            }
            // 핀볼이 어떤 블록을 만나는 경우 위치 또는 방향이 바뀐다.
            // 점수가 1점 오른다.
            // 벽에 부딫히기 때문에
            int block = pinball[curX][curY];
            if (block >= 1 && block <= 5) {
                curDir = blocks[block][curDir];
                score++;
            } else if (block >= 6 && block <= 10) {
                // 워프시키기
                int[] wormhole = wormholes[block-6].get(0);
                if (wormhole[0] == curX && wormhole[1] == curY) {
                    curX = wormholes[block-6].get(1)[0];
                    curY = wormholes[block-6].get(1)[1];
                } else {
                    curX = wormhole[0];
                    curY = wormhole[1];
                }
            } else if (block == -1) {
                return score;
            }

            // 시작 지점에 도착하는 경우 게임이 종료된다.
            if (curX == sx && curY == sy) break;
        }
        return score;
    }

}
/*
5
10
0 1 0 3 0 0 0 0 7 0
0 0 0 0 -1 0 5 0 0 0
0 4 0 0 0 3 0 0 2 2
1 0 0 0 1 0 0 3 0 0
0 0 3 0 0 0 0 0 6 0
3 0 0 0 2 0 0 1 0 0
0 0 0 0 0 1 0 0 4 0
0 5 0 4 1 0 7 0 0 5
0 0 0 0 0 1 0 0 0 0
2 0 6 0 0 4 0 0 0 4
 */