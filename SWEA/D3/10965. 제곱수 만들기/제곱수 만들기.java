import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			int n = Integer.parseInt(br.readLine());
			int answer = checker(n);
			
			bw.write("#" + (t+1) + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int checker(int n){
		int A = n;
		int b = 1;
		if(n == 1) return 1;
		for(int i = 2; i * i <= n; i++){
			int cnt = 0;
			while(A % i == 0){
				cnt++;
				A /= i;
			}
			if(cnt % 2 == 1){
				b *= i;
			}
		}
		if(A > 1){
			b *= A;
		}
		
		return b;
	}
}
