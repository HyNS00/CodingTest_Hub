import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			String answer = calculate(h1,m1,h2,m2);
			bw.write(String.format("#%d %s\n",test+1, answer));
		}
		bw.flush();
		br.close();
		bw.close();
	}
	private static String calculate(int a, int b, int c, int d) {
		int h = a+c;
		int m = b +d;
		if(m >=60) {
			h += (m/60);
			m %= 60;
		}
		if(h > 12) {
			h -= 12;
		}
		StringBuilder sb= new StringBuilder();
		return sb.append(h).append(" ").append(m).toString();
	}
}