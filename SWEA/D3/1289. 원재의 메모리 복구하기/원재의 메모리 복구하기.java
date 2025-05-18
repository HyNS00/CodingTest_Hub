
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			String ori = br.readLine();
			int answer = checker(ori);
			bw.write("#" + (t+1)+ " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int checker(String original){
		int cnt = 0;
		int n = original.length();
		char prev = '0';
		for(char curr : original.toCharArray()){
			
			if(prev != curr){
				cnt++;
			}
			prev = curr;
		}
		return cnt;
	}
}
