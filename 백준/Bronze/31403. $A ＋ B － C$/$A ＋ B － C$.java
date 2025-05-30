

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        Integer intA = Integer.valueOf(A);
        String B = br.readLine();
        Integer intB = Integer.valueOf(B);

        String C = br.readLine();
        Integer intC = Integer.valueOf(C);

        System.out.println(intA + intB - intC);
        
        String strAppend = A + B;
        Integer intSum = Integer.valueOf(strAppend);
        System.out.println(intSum - intC);
        

    }


}