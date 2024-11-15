import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n][n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] arr1 = change(dp);
			int[][] arr2 = change(arr1);
			int[][] arr3 = change(arr2);
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(arr1[i][j]);
				}
				sb.append(" ");
				for(int j = 0; j < n; j++) {
					sb.append(arr2[i][j]);
				}
				sb.append(" ");
				for(int j = 0; j < n; j++) {
					sb.append(arr3[i][j]);
				}
				sb.append("\n");
			}
			bw.write(String.format("#%d\n",test+1));
            bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int[][] change(int[][] tmp) {
		int n = tmp.length;
		int[][] answer = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				answer[i][j] = tmp[n-j-1][i];
			}
		}
		return answer;
	}
	
}
