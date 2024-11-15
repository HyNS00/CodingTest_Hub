import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int[][] dp = new int[9][9];
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer= 0;
			if(checkRow(dp) && checkBox(dp)) {
				answer = 1;
			}
			bw.write(String.format("#%d %d\n",test+1,answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static boolean checkRow(int[][] dp) {
		for(int i = 0; i < 9; i++) {
			Set<Integer> row = new HashSet<>();
			Set<Integer> col = new HashSet<>();
			for(int j = 0; j <9; j++) {
				if(!row.add(dp[i][j]) || !col.add(dp[j][i])) {
					return false;
				}
			}
		}
		return true;
	}
	private static boolean checkBox(int[][] dp) {
		
		for(int row = 0; row < 9; row += 3) {
			for(int col = 0; col < 9; col += 3) {
				Set<Integer> box = new HashSet<>();
				for(int x = 0; x < 3; x++) {
					for(int y = 0; y < 3; y++) {
						if(!box.add(dp[row + x][col + y])) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}