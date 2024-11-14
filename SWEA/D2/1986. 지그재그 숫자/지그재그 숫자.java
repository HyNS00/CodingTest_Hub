import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int test = 0; test < n; test++) {
			int t = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int i = 1; i <= t; i++) {
				if(i % 2 != 0) {
					sum+= i;
				}else {
					sum -= i;
				}
			}
			bw.write(String.format("#%d %d\n", test+1,sum));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}