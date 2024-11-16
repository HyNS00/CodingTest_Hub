import java.io.*;
import java.util.Base64;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			String tmp = br.readLine();
			String result = new String(Base64.getDecoder().decode(tmp));
			bw.write(String.format("#%d %s\n",test+1, result));
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}