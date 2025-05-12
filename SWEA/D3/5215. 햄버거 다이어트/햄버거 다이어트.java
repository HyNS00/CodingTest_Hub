
import java.util.*;
import java.io.*;
public class Solution {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[] cal = new int[N+1];
			int[] score = new int[N+1];
			int[] dp = new int[L+1];
			for(int i = 1; i <= N; i++){
				st = new StringTokenizer(br.readLine());
				
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			int answer = checker(dp,cal,score,N,L);
			bw.write("#" +(t+1)+" " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int checker(int[] dp, int[] cal, int[] score, int n, int L){
		for(int i = 1; i <= n; i++){
			for(int j = L; j >= cal[i]; j--){
				dp[j] = Math.max(dp[j], dp[j-cal[i]] + score[i]);
			}
		}
		return dp[L];
	}
}
