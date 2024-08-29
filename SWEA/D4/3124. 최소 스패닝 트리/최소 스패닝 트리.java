/**
 * 메모리 : 195,712
 * 실행 시간 :  6698 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

/*
1
3 3
1 2 1
2 3 2
1 3 3
*/
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, V, E;
	static Edge[] edges;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			long weightSum = 0;
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edges = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				edges[i] = new Edge(u, v, w);
			}

			// 정점, 정점, 가중치 입력
			// 단독 트리 생성
			makeSet();
			// 가중치를 오름차순으로 간선 정렬
			Arrays.sort(edges);
			// 이어진 간선이 V-1개가 될 때까지 UnionFind
			int cnt = 0;
			for (int i = 0; i < E; i++) {
				int u = edges[i].u;
				int v = edges[i].v;
				int w = edges[i].w;
				if (union(u, v)) {
					// 합치기 성공
					weightSum += w;
					if (++cnt == V - 1) {
						break;
					}
				}
			}

			sb.append("#").append(t).append(" ").append(weightSum).append("\n");
		}
		System.out.println(sb);
	}

	private static void makeSet() {
		parents = new int[V+1];
		for (int i = 0; i <= V; i++) {
			parents[i] = -1;
		}
	}

	private static boolean union(int u, int v) {
		int uRoot = findSet(u);
		int vRoot = findSet(v);
		if (uRoot == vRoot) return false;

		parents[uRoot] += parents[vRoot];
		parents[vRoot] = uRoot;

		return true;
	}

	private static int findSet(int u) {
		if (parents[u] < 0) return u;
		return parents[u] = findSet(parents[u]);
	}

	static class Edge implements Comparable<Edge> {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u; this.v = v; this.w = w;
		}
		@Override
		public int compareTo(Edge edge) {
			return this.w - edge.w;
		}
	}
}