import java.util.*;
import java.io.*;
public class Solution {
	static char[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,-1},{1,1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			int N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			
			for(int i = 0; i < N; i++){
				map[i] = br.readLine().toCharArray();
			}
			boolean flag = false;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(map[i][j] == 'o' && checker(i,j)){
						flag = true;
						break;
					}
				}
			}
			String answer = flag ? "YES" : "NO";
			bw.write("#"+(t+1) + " " + answer +"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static boolean checker(int x, int y){
		for(int i = 0; i < 8; i++){
			int dx = dir[i][0];
			int dy = dir[i][1];
			int cnt = 1;
			int nx = x + dx;
			int ny = y + dy;
			
			while(nx >= 0 && ny >= 0 && nx < map.length && ny < map.length && map[nx][ny] != '.'){
				nx += dx;
				ny += dy;
				cnt++;
				
				if(cnt >= 5){
					return true;
				}
			}
			
		}
		return false;
	}
}
