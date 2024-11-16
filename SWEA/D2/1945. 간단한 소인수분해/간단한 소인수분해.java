
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int num = Integer.parseInt(br.readLine());
			String answer = result(num);
			bw.write(String.format("#%d %s\n",test+1,answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static String result(int k) {
		StringBuilder sb = new StringBuilder();
		int[] units = {2,3,5,7,11};
		int idx = 0;
		int cnt = 0;
		while(k != 0) {
			if(k % units[idx] == 0) {
				k /= units[idx];
				cnt++;
			}else {
				sb.append(cnt).append(" ");
				idx++;
				cnt =0;
				if(idx == 5) {
					break;
				}
			}
		}
		return sb.toString();
	}
}
