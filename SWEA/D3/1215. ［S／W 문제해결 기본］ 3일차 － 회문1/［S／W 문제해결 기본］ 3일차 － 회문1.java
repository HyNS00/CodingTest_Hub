
import java.util.*;
import java.io.*;

public class Solution {
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		for(int t = 0; t < T; t++){
			int len = Integer.parseInt(br.readLine());
			char[][] map = new char[8][8];
			cnt = 0;
			for(int i = 0; i < 8; i++){
				map[i] = br.readLine().toCharArray();
			}
			checkRow(len,map);
			checkCol(len,map);
			bw.write("#"+(t+1)+" "+ cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void checkRow(int len, char[][] map){
		for(int i = 0; i < 8; i++){
			char[] row = map[i];
			for(int start = 0; start <= 8- len; start++){
				if(isP(start, len+start-1, row)){
					cnt++;
				}
			}
		}
	}
	
	public static void checkCol(int len, char[][] map){
		for(int i = 0; i < 8; i++){
			char[] col = new char[8];
			for(int j = 0; j < 8; j++){
				col[j] = map[j][i];
			}
			for(int start = 0; start <= 8-len; start++){
				if(isP(start,len+start-1,col)){
					cnt++;
				}
			}
		}
	}
	
	private static boolean isP(int start, int end, char[] row){
		while(start < end){
			if(row[start] != row[end]){
				return false;
			}
			end--;
			start++;
		}
		return true;
	}
}
