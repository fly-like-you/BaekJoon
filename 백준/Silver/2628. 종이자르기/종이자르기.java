
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int colLen;
    static int rowLen;
    static List<Integer> colArr;
    static List<Integer> rowArr;
    public static void main(String[] args) throws IOException {
        // 0은 가로로 자르기 1은 세로로 자르기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        colLen = Integer.parseInt(st.nextToken());
        rowLen = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        colArr = new ArrayList<>();
        rowArr = new ArrayList<>();
        colArr.add(0); colArr.add(colLen); rowArr.add(0); rowArr.add(rowLen);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int axis = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if (axis == 0) {
                rowArr.add(idx);
            } else {
                colArr.add(idx);
            }
        }
        Collections.sort(rowArr);
        Collections.sort(colArr);


        int maxSize = 0;
        for (int i = 0; i < rowArr.size() - 1; i++) {
            int height = rowArr.get(i + 1) - rowArr.get(i);
            for (int j = 0; j < colArr.size() - 1; j++) {
                int width = colArr.get(j + 1) - colArr.get(j);
                int size = height * width;
                if (size > maxSize) {
                   maxSize = size;
                }
            }
        }
        System.out.println(maxSize);
    }

}

