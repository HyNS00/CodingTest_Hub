import java.io.*;
public class Solution {
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean[][] map = new boolean[n][n];
			count = 0;
			dfs(map,0,n);
			bw.write("#"+(i+1)+" "+ count+ "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(boolean[][] map, int row,int n) {
		if(row == n) {
			count++;
			return;
		}
		for(int i = 0; i < n; i++) {
			if(check(row,i,map)) {
				map[row][i] = true;
				dfs(map,row+1,n);
				map[row][i] = false;
			}
		}
	}
	private static boolean check(int row, int col, boolean[][] map) {
		int n = map.length;
		for(int i = 0; i < n; i++) {
			if(map[i][col]) {
				return false;
			}
		}
		
		for(int i = row-1, j = col-1; i >= 0 && j >=0; i--,j--) {
			if(map[i][j]) return false;
		}
		
		for(int i = row-1, j = col+1; i >= 0 && j < n; i--,j++) {
			if(map[i][j]) return false;
		}
		return true;
	}
}
