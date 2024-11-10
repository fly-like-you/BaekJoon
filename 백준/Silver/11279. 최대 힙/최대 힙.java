import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ABSHeap heap = new ABSHeap(new int[100_000]);
//    static ABSHeap heap = new ABSHeap(new int[20]);
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v == 0) {
                sb.append(heap.poll()).append("\n");
//                System.out.println(Arrays.toString(heap.heap));
            } else {
                heap.add(v);
//                System.out.println(Arrays.toString(heap.heap));
            }
        }

        System.out.println(sb);

    }
    static class ABSHeap {
        int[] heap;
        int size;

        public ABSHeap(int[] heap) {
            this.heap = heap;
            this.size = 0;
        }

        void heapify(int cur) {
            int largest = cur;
            int l = cur * 2;
            int r = cur * 2 + 1;

            // 왼쪽 노드가 true인 경우
            if (l <= size && !isCondition(heap[largest], heap[l])) {
                largest = l;
            }
            // 오른쪽 노드가 true인 경우
            if (r <= size && !isCondition(heap[largest], heap[r])) {
                largest = r;
            }

            // 값이 변경 되었을 경우
            if (cur != largest) {
                swap(cur, largest);
                heapify(largest);
            }
            // 스왑 해주고 재귀
        }

        int poll() {
            // 배열이 비어있으면 0출력
            if (size == 0) return 0;
            int retVal = heap[1];
            heap[1] = heap[size];
            heap[size--] = 0;
            heapify(1);

            return retVal;
        }

        void add(int x) {
            heap[++size] = x;
            int i = size;
            while (i > 1 && isCondition(heap[i], heap[i/2])) {
                swap(i, i/2);
                i /= 2;
            }
        }

        // t1이 t2보다 더 크다면 true
        // t1의 절댓값이 더 크다면 true
        // 절댓값이 같고 t1이 더 작다면
        private boolean isCondition(int t1, int t2) {
            return t1 > t2;
//            int calc = Math.abs(t1) - Math.abs(t2); // 절댓값 차이
//            if (calc != 0) { //
//                return calc > 0; // t1이 값이 크다면 true
//            }
//
//            // 0 이라면
//            return t1 > t2;
        }

        private void swap(int idx1, int idx2) {
//            System.out.println(Arrays.toString(heap));
            int temp = heap[idx1];
            heap[idx1] = heap[idx2];
            heap[idx2] = temp;
        }
    }
}