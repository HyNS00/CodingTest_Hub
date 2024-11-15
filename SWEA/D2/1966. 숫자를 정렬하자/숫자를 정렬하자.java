import java.io.*;
import java.util.stream.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			String answer = change(tmp);
			
			bw.write(String.format("#%d %s\n",test+1, answer));
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static String change(String[] tmp) {
		StringBuilder sb = new StringBuilder();
		int[] result = Arrays.stream(tmp).mapToInt(Integer::parseInt).sorted().toArray();
		for(int i : result) {
			sb.append(i).append(" ");
		}
		return sb.toString();
	}
}