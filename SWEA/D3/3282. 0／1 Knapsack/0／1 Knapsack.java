
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] weights = new int[N+1];
			int[] values = new int[N+1];
			for(int i = 0; i < N; i++){
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				weights[i+1] = v;
				values[i+1] = c;
			}
			int[][] dp = new int [N+1][K+1];
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= K; j++){
					if(j - weights[i] >= 0){
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			int answer= dp[N][K];
			bw.write("#" +(t+1) + " " +answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
