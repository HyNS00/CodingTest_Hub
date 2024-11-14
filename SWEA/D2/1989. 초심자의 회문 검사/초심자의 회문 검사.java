import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int test = 0; test < n; test++) {
			String tmp = br.readLine();
			StringBuilder sb = new StringBuilder();
			int answer = 0;
			String check = sb.append(new String(tmp.toCharArray())).reverse().toString();
			if(tmp.equals(check)) {
				answer = 1;
			}
			bw.write(String.format("#%d %d\n",test+1, answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}