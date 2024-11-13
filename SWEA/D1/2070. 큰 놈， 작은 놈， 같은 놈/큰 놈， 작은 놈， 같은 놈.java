import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String answer = "";
			String a = st.nextToken();
            String b = st.nextToken();
            answer = check(a,b);
			bw.write("#"+(i+1)+ " " + answer +"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	private static String check(String a, String b){
		int A = Integer.parseInt(a);
		int B = Integer.parseInt(b);
		
		if(A < B){
			return "<";
		}else if(A > B){
			return ">";
		}else{
			return "=";
		}
	}
}	
