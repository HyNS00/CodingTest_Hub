
import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
	
	static ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		for(int t = 0; t < 10; t++){
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			for(int i = 0; i < n; i++){
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
						.toArray();
			}
			
			int answer =checker(stack, map);
			bw.write("#" + (t+1) + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int checker(ArrayDeque<Integer> stack, int[][] map){
		int n = map.length;
		
		int cnt = 0;
		for(int col = 0; col < n; col++){
			stack.clear();
			for(int row = 0; row < n; row++){
				if(map[row][col] == 1){
					stack.push(1);
				}
				if(map[row][col] == 2 && !stack.isEmpty() && stack.peek() == 1){
					cnt++;
					stack.clear();
				}
			}
		}
		
		return cnt;
	}
}
