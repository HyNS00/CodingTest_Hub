import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		String[] grade = {"D0","C-","C0","C+","B-","B0","B+","A-","A0","A+"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			double[] scores = new double[n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				scores[i] = 0.35 * a + 0.45 * b + 0.2 * c;
			}
			double student = scores[k-1];
			Arrays.sort(scores);
			for(int j = 0; j < n; j++) {
				if(scores[j] == student) {
					bw.write(String.format("#%d %s\n",test+1, grade[j/(n/10)]));
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}