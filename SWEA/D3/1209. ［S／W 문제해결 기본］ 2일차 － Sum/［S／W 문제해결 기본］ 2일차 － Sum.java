

import java.util.*;
import java.io.*;

public class Solution {
	static int sum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] map = new int[100][100];
		for(int i = 0; i < 10; i++){
			int n = Integer.parseInt(br.readLine());
			
			
			for(int j = 0; j < 100; j++){
				map[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
						.toArray();
			}
			sum = 0;
			checker(map);
			checkDig(map);
			
			bw.write("#"+(i+1)+" " + sum+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void checker(int[][] map){
		
		for(int i = 0; i < 100; i++){
			int tmp1 = 0;
			int tmp2 = 0;
			for(int j = 0; j < 100; j++){
				tmp1 += map[i][j];
				tmp2 += map[j][i];
			}
			sum = Math.max(sum, tmp1);
			sum = Math.max(sum, tmp2);
		}
	}
	
	public static void checkDig(int[][] map){
		int tmp1 = 0;
		int tmp2 = 0;
		for(int i = 0; i < 100; i++){
			tmp1 += map[i][i];
			tmp2 += map[i][99-i];
		}
		sum = Math.max(sum, Math.max(tmp1, tmp2));
	}
}
