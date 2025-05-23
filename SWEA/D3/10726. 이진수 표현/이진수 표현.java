import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			String answer = checker(M,N) ? "ON" : "OFF";
			bw.write("#" + (t+1) +" " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static boolean checker(int M,int N){
		for(int i = 0; i < N; i++){
			if(M % 2 == 0){
				return false;
			}
			M /= 2;
		}
		
		return true;
	}
}
