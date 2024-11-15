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
			int k = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for(int i = 0; i < n; i++) {
				int cnt = 0;
				for(int j = 0;  j < n; j++) {
					if(dp[i][j] == 1) {
						cnt++;
					}else {
						if(cnt == k) {
							result++;
						}
						cnt = 0;
					}
				}
				if(cnt == k) result++;
			}
			
			for(int j = 0; j < n; j++) {
				int cnt = 0;
				for(int i = 0; i < n; i++) {
					if(dp[i][j] == 1) {
						cnt++;
					}else {
						if(cnt == k) {
							result++;
						}
						cnt = 0;
					}
				}
				if(cnt == k) result++;
			}
			
			bw.write(String.format("#%d %d\n", test+1,result));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}