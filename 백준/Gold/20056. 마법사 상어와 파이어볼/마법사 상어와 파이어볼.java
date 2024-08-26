import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/*
4 2 1
1 1 5 2 2
1 4 7 1 6
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K;
    static Map<P, List<F>> fBalls;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        fBalls = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            List<F> li = new ArrayList<>();
            P p = new P(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            li.add(new F(p, m, s, d));
            fBalls.put(p, li);
        }

        for (int k = 0; k < K; k++) {
            // 새로운 위치를 저장할 맵
            Map<P, List<F>> newFBalls = new HashMap<>();

            // 기존 맵에서 파이어볼을 이동시켜 새로운 맵에 추가
            for (List<F> l : fBalls.values()) {
                for (F fBall : l) {
                    P newP = fBall.move();
                    newFBalls.computeIfAbsent(newP, key -> new ArrayList<>()).add(fBall);
                }
            }

            // 새로운 맵을 원본 맵으로 교체
            fBalls = newFBalls;

            // 이동이 끝난 뒤 2개 이상인 리스트를 찾기
            for (P p : fBalls.keySet()) {
                List<F> li = fBalls.get(p);
                if (li.size() >= 2) {
                    divide(li);
                }
            }
        }

        int answer = 0;
        for (List<F> l : fBalls.values()) {
        	for (int i = 0; i < l.size(); i++) {
				answer += l.get(i).m;
			}
        }
        System.out.println(answer);
    }

    private static void divide(List<F> list) {
        //같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
        int mSum = 0;
        int sSum = 0;
        int fCnt = list.size();
        P p = null;
        boolean dirFlag = true;
        int dir = list.get(0).d % 2; // true = 홀수
        for (int i = 0; i < fCnt; i++) {
            F f = list.remove(0);
            p = f.p;
            mSum += f.m;
            sSum += f.s;
            if (dir != f.d % 2) {
            	dirFlag = false;
            }
        }
        //질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
        int m = mSum / 5;
        //속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
        int s = sSum / fCnt;
        //질량이 0인 파이어볼은 소멸되어 없어진다.
        if (m == 0) return;

        //파이어볼은 4개의 파이어볼로 나누어진다.
        for (int i = 0; i < 8; i+=2) {
        	//합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
        	if (dirFlag) {
        		list.add(new F(p, m, s, i));
        	} else {
        		list.add(new F(p, m, s, i+1));
        	}	
		}

    }


    static class P {
        int x, y;
        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            P p = (P) object;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

		@Override
		public String toString() {
			return "x=" + x + ", y=" + y;
		}
        
    }

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static class F {
        P p;
        int m, d, s;
        public F(P p, int m, int s, int d) {
            this.p = p;
            this.m = m;
            this.d = d;
            this.s = s;
        }
        public P move() {
            // 이동하려는 방향이 좌표계보다 큰경우 열 또는 형의 반대편으로 다시 이동시켜주기
            int nx = (p.x + N + dx[d] * (s%N)) % N;
            int ny = (p.y + N + dy[d] * (s%N)) % N;
            if (nx < 0) {
                nx += N;
            }
            if (ny < 0) {
                ny += N;
            }
            this.p = new P(nx,ny);
            return this.p;
        }
		@Override
		public String toString() {
			return "p=" + p + ", m=" + m + ", d=" + d + ", s=" + s;
		}
        
    }
}