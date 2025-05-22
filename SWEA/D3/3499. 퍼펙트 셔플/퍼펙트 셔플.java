import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			int n = arr.length;
			StringBuilder sb = new StringBuilder();
			if(n % 2 == 0){
				for(int i = 0; i < n/2; i++){
					int j = i + n/2;
					sb.append(arr[i]).append(" ").append(arr[j]).append(" ");
				}
			}else{
				String tmp = arr[n/2]; // 가운데
				for(int i =0; i < n/2; i++){
					int j = i + 1 + n/2;
					sb.append(arr[i]).append(" ").append(arr[j]).append(" ");
				}
				sb.append(tmp);
			}
			bw.write("#" + (t+1) + " " + sb.toString() +"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
