import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        if (M == 0) {
            System.out.println(Math.min(String.valueOf(channel).length(), Math.abs(100 - channel)));
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<String> brokenBtn = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String i = st.nextToken();
            brokenBtn.add(i);
        }
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i <= 999999; i++) {
            List<String> channelArr = Arrays.stream(String.valueOf(i).split(""))
                    .collect(Collectors.toList());
            if (isPossible(brokenBtn, channelArr)) {
                int val = channelArr.size() + Math.abs(channel - i);
                minVal = Math.min(val, minVal);
            }
        }

        minVal = Math.min(minVal, Math.abs(100 - channel));
        System.out.println(minVal);
    }

    static boolean isPossible(List<String> brokenBtn, List<String> channel) {
        for (String chn : channel) {
            if (brokenBtn.contains(chn)) {
                return false;
            }
        }
        return true;
    }

}
