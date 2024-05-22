import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String N = st.nextToken();
        String M = st.nextToken();
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();

        for (int i = 1; i < Integer.parseInt(N)+1; i++) {
            String pokemon = br.readLine();
            map.put(String.valueOf(i), pokemon);
            map2.put(pokemon, String.valueOf(i));
        }

        for (int i = 0; i < Integer.parseInt(M); i++) {
            String question = br.readLine();
            if (map.containsKey(question)) {
                System.out.println(map.get(question));
            } else {
                System.out.println(map2.get(question));
            }
        }
    }

}
