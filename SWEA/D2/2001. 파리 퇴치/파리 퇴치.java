
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] dp = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int i = 0; i <= n-m; i++) {
				for(int j = 0; j <= n-m; j++) {
					int tmp = 0;
					for(int x = 0; x < m; x++) {
						for(int y = 0; y < m; y++) {
							tmp += dp[i+x][j+y];
						}
					}
					max = Math.max(tmp, max);
				}
			}
			bw.write(String.format("#%d %d\n", (test+1),max));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
