import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int answer= 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			answer = check(a,b,c);
			bw.write(String.valueOf(answer)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int check(int a, int b, int c) {
		int cnt = 0;
		if(a > c || b > c) return cnt;
		while(a <= c && b <= c) {
			if(a <= b) {
				a +=b;
			}
			else {
				b += a;
			}
			cnt++;
		}
		return cnt;
	}
}
