import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < t; test++) {
			String answer = "";
			int[] count = new int[8];
			long money = Long.parseLong(br.readLine());
			answer = check(count, money);
			
			bw.write(String.format("#%d\n%s\n",test+1,answer));
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static String check(int[] arr, long m) {
		int[] units = {50000,10000,5000,1000,500,100,50,10};
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 8; i++) {
			arr[i] = (int) (m / units[i]);
			m %= units[i];
		}
		for(int i : arr) {
			sb.append(i+ " ");
		}
		return sb.toString();
	}
}