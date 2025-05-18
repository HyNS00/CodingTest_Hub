import java.util.*;
import java.io.*;
public class Solution {
	static int len;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t = 0; t < 10; t++){
			int n = Integer.parseInt(br.readLine());
			
			char[][] map = new char[100][100];
			
			for(int i  = 0; i < 100; i++){
				map[i] = br.readLine().toCharArray();
			}
			
			len = 1;
			checkRow(map);
			checkCol(map);
			bw.write("#"+(n)+" "+len+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void checkRow(char[][] map){
		for(int length = 100; length > len; length--){
			for(int i = 0; i < 100; i++){
				char[] tmp = map[i];
				for(int start = 0; start < 101 - length; start++){
					if(isPal(start,start+length-1,tmp)){
						len = Math.max(len, length);
					}
				}
			}
		}
	}
	public static void checkCol(char[][] map){
		for(int length = 100; length > len; length--){
			for(int i = 0; i < 100; i++){
				for(int start = 0; start < 101-length; start++){
					if(isPalc(start,start+length-1,map,i)){
						len = Math.max(len, length);
					}
				}
			}
		}
	}
	
	private static boolean isPal(int start, int end, char[] target){
		while(start < end){
			if(target[start] != target[end]){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	private static boolean isPalc(int start, int end, char[][] map, int col){
		while(start < end){
			if(map[start][col] != map[end][col]){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
