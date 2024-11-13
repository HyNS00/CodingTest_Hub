
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t; i++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a % 2 != 0){
					sum += a;
				}
			}
			bw.write("#"+(i+1)+ " " +sum+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}