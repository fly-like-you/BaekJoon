import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] votes;
    static int[] counts;
    public static void main(String[] args) throws IOException {
        votes = br.readLine().toCharArray();
        counts = new int[4];
        for (int i = 0; i < votes.length; i++) {
            char vote = votes[i];
            switch (vote) {
                case 'U':
                    ++counts[0];
                    break;
                case 'D':
                    ++counts[1];
                    break;
                case 'P':
                    ++counts[2];
                    break;
                case 'C':
                    ++counts[3];
                    break;
            }

        }
        int ucSum = counts[0] + counts[3];
        int dpSum = counts[1] + counts[2];
        if (ucSum > dpSum / 2 + dpSum % 2) {
            System.out.print("U");
        }
        if (dpSum != 0) {
            System.out.println("DP");
        }


    }
}
/*
u u
c c
c u
d d
p p
*/