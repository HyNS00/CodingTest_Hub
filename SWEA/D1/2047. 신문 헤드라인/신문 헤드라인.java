import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] ars) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp = br.readLine();
		String answer = tmp.toUpperCase();
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}
}