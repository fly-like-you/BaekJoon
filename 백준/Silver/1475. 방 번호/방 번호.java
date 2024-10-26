import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다.
 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오.
(6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
 */
public class Main {
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] room;
    static int[] nums;
    /*
    배울 수 있던 점
    6과 9를 겸해서 사용할 수 있다는 점에서

     */
    public static void main(String[] args) throws IOException {
        // 6 -> 9, 9 -> 6
        // 0, 1, 2, 3, 4, 5, 7, 8
        room = br.readLine().toCharArray();
        nums = new int[10];
        // 2 세트, 123456789123456789
        // 4564 -> 2세트, 4569 -> 1세트
        // 0 1 2 3 4 5 6 7 8 9
        // 0 0 0 0 2 1 1 0 0 0
        for (int i = 0; i < room.length; i++) {
            // char를 int로 변환하기
            int num = Character.digit(room[i], 10);
            nums[num]++;
        }
        int min = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            min = Math.max(nums[i], min);
        }
        int sum = nums[6] + nums[9];
        min = Math.max(min, sum / 2 + sum % 2);
        System.out.println(min);
    }
}
/*
9999
 */