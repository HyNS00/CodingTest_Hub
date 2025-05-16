
import java.util.*;
import java.io.*;
public class Solution {
	static HashMap<Character,String> dirMap = new HashMap<>();
	static HashMap<String,Character> symbolMap = new HashMap<>();
	static List<String> directions = Arrays.asList("up","down","left","right");
	static int[][] moving = {{-1,0},{1,0},{0,-1},{0,1}};
	static{
		dirMap.put('U', "up");
		dirMap.put('D', "down");
		dirMap.put('L', "left");
		dirMap.put('R', "right");
		
		symbolMap.put("up", '^');
		symbolMap.put("down", 'v');
		symbolMap.put("left", '<');
		symbolMap.put("right", '>');
	}
	static class Tank{
		String direction;
		int x;
		int y;
		
		public Tank(String direction, int x, int y){
			this.direction = direction;
			this.x = x;
			this.y = y;
		}
		
		public void shoot(char[][] map){
			int idx = directions.indexOf(this.direction);
			int dx = moving[idx][0];
			int dy = moving[idx][1];
			
			int nx = this.x;
			int ny = this.y;
			
			while(true){
				nx += dx;
				ny += dy;
				
				if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) break;
				
				if(map[nx][ny] == '#') break;
				
				if(map[nx][ny] == '*'){
					map[nx][ny] = '.';
					break;
				}
			}
		}
		
		public void move(char[][] map, char d){
			this.direction = dirMap.get(d);
			
			int x = this.x;
			int y = this.y;
			
			int idx = directions.indexOf(this.direction);
			int dx = moving[idx][0];
			int dy = moving[idx][1];
			
			int nx = x+dx;
			int ny = y + dy;
			if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] == '.'){
				map[nx][ny] = symbolMap.get(this.direction);
				map[this.x][this.y] = '.';
				this.x = nx;
				this.y = ny;
			}else{
				map[x][y] = symbolMap.get(this.direction);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			Tank tank = null;
			char[][] map = new char[H][W];
			for(int i = 0; i < H; i++){
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < W; j++){
					if(map[i][j] == '^'){
						tank = new Tank("up",i,j);
					}else if(map[i][j] == '<'){
						tank = new Tank("left",i,j);
					}else if(map[i][j] == '>'){
						tank = new Tank("right",i,j);
					}else if(map[i][j] == 'v'){
						tank = new Tank("down",i,j);
					}
				}
			}
			int number = Integer.parseInt(br.readLine());
			char[] co = br.readLine().toCharArray();
			for(char c : co){
				if(c == 'S'){
					tank.shoot(map);
				}else{
					tank.move(map,c);
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < H; i++){
				for(int j = 0; j < W; j++){
					sb.append(map[i][j]);
				}
				if(i < H-1){
					sb.append("\n");
				}
			}
			bw.write("#"+(t+1)+" " + sb.toString()+ "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
