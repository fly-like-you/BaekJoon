import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V;
    static Node[] adjMatrix;
    static class Node {
        double x, y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
/*
3
1.0 1.0
2.0 2.0
2.0 4.0
*/
    public static void main(String[] args) throws IOException {

        V = Integer.parseInt(br.readLine());
        adjMatrix = new Node[V];

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            adjMatrix[i] = new Node(x, y);
        }

        System.out.printf("%.2f", getMSTCost());
    }

    private static double getMSTCost() {
        boolean[] visited = new boolean[V];
        double[] minEdges = new double[V];
        double result = 0;

        Arrays.fill(minEdges, Double.MAX_VALUE);
        minEdges[0] = 0;

        for (int i = 0; i < V; i++) {
            double min = Double.MAX_VALUE;
            int minVertex = -1;

            for (int j = 0; j < V; j++) {
                if (!visited[j] && minEdges[j] < min) {
                    min = minEdges[j];
                    minVertex = j;
                }
            }

            if (minVertex == -1) return -1;
            visited[minVertex] = true;
            result += min;

            for (int j = 0; j < V; j++) {
                double distance = getDistance(adjMatrix[minVertex], adjMatrix[j]);
                if (!visited[j] && minEdges[j] > distance) {
                    minEdges[j] = distance;
                }
            }
        }

        return result;
    }

    private static double getDistance(Node n1, Node n2) {
        return Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
    }


}