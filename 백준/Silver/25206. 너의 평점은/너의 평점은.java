

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static double[][] subject;
	
	
	public static void main(String[] args) throws IOException {

		double creditSum = 0;
		double scoreSum = 0;
		for (int t = 0; t < 20; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			double credit = Double.parseDouble(st.nextToken());
			
			
			String scoreStr = st.nextToken();
			double score;
			switch (scoreStr) {
				case "A+": score = 4.5; break;
				case "A0": score = 4.0; break;
				case "B+": score = 3.5; break;
				case "B0": score = 3.0; break;
				case "C+": score = 2.5; break;
				case "C0": score = 2.0; break;
				case "D+": score = 1.5; break;
				case "D0": score = 1.0; break;
				case "F": score = 0; break;
				default: score = -1;
			}
			if (score == - 1) continue;
			creditSum += credit;
			scoreSum += score * credit;

		}

		System.out.printf("%.6f",scoreSum / creditSum);
	}
}
