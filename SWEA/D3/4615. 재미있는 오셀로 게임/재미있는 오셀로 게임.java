
import java.util.*;
import java.io.*;
public class Solution {
	static int[] dx = {1,-1,0,0,-1,1,-1,1};
	static int[] dy = {0,0,1,-1,1,1,-1,-1};
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			map[N/2-1][N/2-1] = 2;
			map[N/2-1][N/2] = 1;
			map[N/2][N/2] = 2;
			map[N/2][N/2-1] =1;
			
			for(int i = 0; i < M; i++){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int color = Integer.parseInt(st.nextToken());
				
				change(x,y,color,map);
			}
			int white = 0;
			int black = 0;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(map[i][j] == 2){
						white++;
					}
					if(map[i][j] == 1) black++;
				}
			}
			bw.write("#"+(t+1)+" "+black+" "+white+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void change(int x, int y, int color, int[][] map){
		int n = map.length;
		map[x][y] = color;
		
		for(int i = 0; i < 8; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			List<int[]> list = new ArrayList<>();
			
			while(checker(nx,ny,n) && map[nx][ny] != 0 && map[nx][ny] != color){
				list.add(new int[] {nx,ny});
				nx += dx[i];
				ny += dy[i];
			}
			
			if(checker(nx,ny,n) && map[nx][ny] == color){
				for(int[] dir : list){
					map[dir[0]][dir[1]] = color;
				}
			}
			
		}
	}
	private static boolean checker(int x, int y, int n){
		if(x >= 0 && x < n && y >= 0 && y < n) {
			return true;
		}
		return false;
	}
}
