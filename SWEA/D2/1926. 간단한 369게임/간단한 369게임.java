import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= a; i++) {
			sb.append(check(i)).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static String check(int a) {
		String tmp = String.valueOf(a);
		if(tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
			tmp = change(tmp);
		}
		return tmp;
	}
	private static String change(String tmp) {
		int k = (int) Arrays.stream(tmp.split("")).filter(x -> "369".contains(x))
				.count();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < k; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}
