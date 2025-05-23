import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			char[][] map = new char[5][];
			int max = 0;
			for(int i = 0; i < 5; i++){
				map[i] = br.readLine().toCharArray();
				max = Math.max(max, map[i].length);
			}
			
			StringBuilder sb = new StringBuilder();
			
			int idx = 0;
			while(idx < max){
				for(int i = 0; i < 5; i++){
					char[] tmp = map[i];
					
					if(idx < tmp.length){
						sb.append(tmp[idx]);
					}
				}
				idx++;
			}
			bw.write("#" + (t+1) + " " + sb.toString()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
