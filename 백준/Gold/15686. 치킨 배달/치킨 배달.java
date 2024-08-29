import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 메모리 : 12912 kb
 * 시간 : 132 ms
 */
public class Main {
    // 브루트 포스
    // 조합을 사용하여 M개의 가게를 결정한 뒤 치킨거리 찾아내기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int storeCnt;
    static int R;
    static ArrayList<Integer[]> stores;
    static ArrayList<Integer[]> homes;
    static int[] storesIdx;
    static int minDistance = Integer.MAX_VALUE;
/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
**/
    public static void main(String[] args) throws IOException {
        // 가게 배열을 저장하고 인덱스
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        homes = new ArrayList<>();
        stores = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int o = Integer.parseInt(st.nextToken());
                if (o == 1) {
                    homes.add(new Integer[]{i, j});
                } else if (o == 2) {
                    stores.add(new Integer[]{i, j});
                    storeCnt++;
                }
            }
        }
        storesIdx = new int[M];
        // 집의 위치 정보, 가게의 위치 정보 , 가게의 수 모두 저장
        combination(0, 0);
        System.out.println(minDistance);
    }
    
    private static void combination(int depth, int prev) {
        if (M == depth) {
            int chickenDist = getCityDistance();
            minDistance = Math.min(minDistance, chickenDist);
            return;
        }

        for (int i = prev; i < storeCnt; i++) {
            storesIdx[depth] = i;
            combination(depth + 1, i + 1);
        }
        
    }

    private static int getCityDistance() {
        int chickenDist = 0;
        for (int i = 0; i < homes.size(); i++) {
            // 거리가 되는 최소의 치킨집 찾기
            Integer[] home = homes.get(i);
            int minStore = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                Integer[] store = stores.get(storesIdx[j]);
                minStore = Math.min(minStore, getChickenDistance(home, store));
            }
            chickenDist += minStore;
        }
        return chickenDist;
    }

    private static int getChickenDistance(Integer[] p1, Integer[] p2) {
        return  Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

}