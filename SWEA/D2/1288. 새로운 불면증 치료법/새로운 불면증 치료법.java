import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			int answer = check(n);
			bw.write(String.format("#%d %d\n", test+1, answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int check(int n) {
		Set<String> set = new HashSet<>();
		int standard = n;
		//  n을 어떻게 1자리씩 셀 수 있을 까
		int cnt = 2;
		while(true) {
			String[] tmp = String.valueOf(n).split("");
			for(String str : tmp) {
				set.add(str);
			}
			if(set.size() == 10) {
				break;
			}
			n = cnt* standard;
			cnt++;
			
		}
		return n;
	}
}