import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, T;
    static Set<String>[] words;
    // 길이가 짧은 순
    // 길이가 같다면 사전순
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append("\n");
            N = Integer.parseInt(br.readLine());
            words = new Set[51];
            for (int i = 0; i < 51; i++) {
                words[i] = new HashSet<>();
            }
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                words[word.length()].add(word);
            }

            for (int i = 1; i < 51; i++) {
                ArrayList<String> l = new ArrayList<>(words[i]);

                Collections.sort(l);
                int size = words[i].size();
                for (int j = 0; j < size; j++) {
                    sb.append(l.get(j)).append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}
/*

1
5
my
name
is
ho
seok
 */