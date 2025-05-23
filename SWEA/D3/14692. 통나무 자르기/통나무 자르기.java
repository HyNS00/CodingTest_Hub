
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			long n = Long.parseLong(br.readLine());
			
			String answer = (n % 2 == 0) ? "Alice" : "Bob";
			
			bw.write("#" + (t+1) + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
