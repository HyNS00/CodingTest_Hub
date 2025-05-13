import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++){
				map[i] = Arrays.stream(br.readLine().split("")).mapToInt(x -> Integer.parseInt(x))
						.toArray();
			}
			int answer = checker(map);
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int checker(int[][] map){
		int n = map.length;
		int sum = 0;
		int s = n/2;
		
		for(int i = 0; i < n; i++){
			int range = Math.abs(s-i);
			int ele = n - 2 * range;
			int start = s - (ele/2);
			int end = s + (ele/2);
			for(int j = start; j <= end; j++){
				sum += map[i][j];
			}
		}
		return sum;
	}
}
