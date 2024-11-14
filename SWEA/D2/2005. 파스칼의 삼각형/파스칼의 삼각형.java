
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= n; test++) {
			int t = Integer.parseInt(br.readLine());
			int[][] dp = new int[t][t];
			dp[0][0] = 1;
			for(int i = 1; i < t; i++) {
				for(int j = 0; j <=i; j++) {
					if(j == 0 || j == i) {
						dp[i][j] = 1;
					}else {
						dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
					}
				}
			}
			bw.write("#"+test+"\n");
			for(int i = 0; i < t; i++) {
				for(int j = 0; j <= i; j++) {
					bw.write(dp[i][j] +" ");
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
