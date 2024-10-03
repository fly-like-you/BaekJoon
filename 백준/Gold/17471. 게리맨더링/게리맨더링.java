import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class City {
        int population;
        char color;
        public City(int population, char color) {
            this.population = population;
            this.color = color;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, populationSum, answer = Integer.MAX_VALUE;
    static int[][] sectors;
    static City[] city;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        city = new City[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) { // 기존에 0부터 N+1까지였는데, 1부터 N까지로 수정
            int population = Integer.parseInt(st.nextToken());
            city[i] = new City(population, 'A');
            populationSum += population;
        }

        sectors = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 첫 번째 수는 건너뜀
            while (st.hasMoreTokens()) {
                int to = Integer.parseInt(st.nextToken());
                sectors[i][to] = sectors[to][i] = 1;
            }
        }

        // 부분 집합으로 A와 B로 나누는 로직 시작
        subset(1, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int dfs(int start, char color) {
        visited[start] = true;
        int count = 1;

        for (int i = 1; i <= N; i++) {
            if (sectors[start][i] == 1 && !visited[i] && city[i].color == color) {
                count += dfs(i, color);
            }
        }
        return count;
    }

    private static void subset(int cur, int aCityPopulation, int aCity) {
        if (cur == N + 1) {
            // 두 개의 선거구로 나눈 후 유효한지 체크
            int bCity = N - aCity; // B 선거구에 속하는 도시 수
            if (aCity == 0 || bCity == 0) return; // A나 B 선거구에 도시가 없으면 건너뜀

            visited = new boolean[N + 1];
            int aCount = dfs(findStart('A'), 'A'); // A 선거구의 연결된 도시 수 확인

            visited = new boolean[N + 1];
            int bCount = dfs(findStart('B'), 'B'); // B 선거구의 연결된 도시 수 확인

            if (aCount == aCity && bCount == bCity) {
                answer = Math.min(answer, Math.abs((populationSum - aCityPopulation) - aCityPopulation));
            }
            return;
        }

        // 현재 도시를 A로 할당
        city[cur].color = 'A';
        subset(cur + 1, aCityPopulation + city[cur].population, aCity + 1);

        // 현재 도시를 B로 할당
        city[cur].color = 'B';
        subset(cur + 1, aCityPopulation, aCity);
    }

    private static int findStart(char color) {
        // B 선거구에 속한 첫 번째 도시를 찾는 함수
        for (int i = 1; i <= N; i++) {
            if (city[i].color == color) {
                return i;
            }
        }
        return -1;
    }
}