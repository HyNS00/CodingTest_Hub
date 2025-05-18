import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t = 0; t < 10; t++){
			int n = Integer.parseInt(br.readLine());
			String target = br.readLine();
			
			String str = br.readLine();
			int answer = checker(str,target);
			bw.write("#" +(t+1) +" " + answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int checker(String str, String target){
		int cnt = 0;
		int n = target.length();
		int all = str.length();
		
		for(int i = 0; i < all- n+1; i++){
			String tmp = str.substring(i,i+n);
			if(tmp.equals(target)) cnt++;
		}
		
		return cnt;
	}
}
