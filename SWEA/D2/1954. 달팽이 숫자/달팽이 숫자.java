import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			int[][] snail = new int[n][n];
			int maxRow = n-1;
			int minRow = 0;
			int maxCol = n-1;
			int minCol = 0;
			int value = 1;
			while(value <= n*n) {
				for(int i = minCol; i <= maxCol; i++) {
					snail[minRow][i] = value++;
				}
				minRow++;
				for(int i = minRow; i <= maxRow; i++) {
					snail[i][maxCol] = value++;
				}
				maxCol--;
				
				for(int i = maxCol; i >= minCol; i--) {
					snail[maxRow][i] = value++;
				}
				maxRow--;
				for(int i =maxRow; i >= minRow; i--) {
					snail[i][minCol] = value++;
				}
				minCol++;
			}
			StringBuilder sb  = new StringBuilder();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
			bw.write(String.format("#%d\n", test+1));
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
