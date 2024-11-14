import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 0; i < t; i++) {
			String tmp = br.readLine();
			answer = check(tmp);
			bw.write(String.format("#%d %d\n", (i+1), answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int check(String tmp) {
		int len = tmp.length();
		for(int i = 1; i < len/2; i++) {
			String pattern = tmp.substring(0,i);
			String checker = tmp.substring(i,i+i);
			if(pattern.equals(checker)) {
				return i;
			}
		}
		return 0;
	}
}
