import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 1. 미세먼지의 확산정보 저장
    // 2. 확산되는 값들은 겹치면안됨
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, T;
    static int[][] room;
    static int purifier;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int dust = Integer.parseInt(st.nextToken());
                room[i][j] = dust;
                if (dust == -1 && purifier == 0) {
                    purifier = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            diffusion();
            purification();
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += room[i][j];
            }
        }
        System.out.println(sum + 2);
    }

    private static void purification() {
        // 공기 청정기 위치 1열 y행
        // purifier = 위쪽 행
        int[] upper = new int[]{purifier-1, 0};
        int[] clockwiseX = {-1, 0, 1, 0};
        int[] clockwiseY = {0, 1, 0, -1};
        int x = upper[0], y = upper[1];
        for (int i = 0; i < 4; i++) {
            while (true) {
                int nx = clockwiseX[i] + x;
                int ny = clockwiseY[i] + y;
                if (nx < 0 || nx > purifier || ny < 0 || ny >= C) break;
                if (room[x][y] == -1) room[nx][ny] = 0; // 현재 공기 청정기
                if (room[nx][ny] == -1) {
                    room[x][y] = 0;
                    break;
                }

                room[x][y] = room[nx][ny];

                x = nx; y = ny;
            }
        }


        int[] lower = new int[]{purifier + 2, 0};
        int[] counterClockwiseX = {1, 0, -1, 0};
        int[] countClockwiseY = {0, 1, 0, -1};
        x = lower[0]; y = lower[1];
        for (int i = 0; i < 4; i++) {
            while (true) {
                int nx = counterClockwiseX[i] + x;
                int ny = countClockwiseY[i] + y;
                if (nx < purifier + 1 || nx >= R || ny < 0 || ny >= C) break;
                if (room[x][y] == -1) room[nx][ny] = 0; // 현재 공기 청정기
                if (room[nx][ny] == -1) {
                    room[x][y] = 0;
                    break;
                }

                room[x][y] = room[nx][ny];

                x = nx; y = ny;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(room[i]));
        }
    }
    private static void diffusion() {
        // 1. 확산될 먼지를 배열에 저장
        int[][] diffusionArr = new int[R][C];


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] <= 0) continue;
                diffusionTask(i, j, diffusionArr);
            }
        }

        // 2. 배열에 저장된 먼지 정보를 원래 배열에 다시 저장
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] += diffusionArr[i][j];
            }
        }
    }

    private static void diffusionTask(int x, int y, int[][] diffusionArr) {
        int diffusionAmount = room[x][y] / 5;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (room[nx][ny] == -1) continue; // 공기 정정기

            diffusionArr[nx][ny] += diffusionAmount;
            room[x][y] -= diffusionAmount;
        }
    }
}