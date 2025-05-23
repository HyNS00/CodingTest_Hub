
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int lower = Integer.parseInt(st.nextToken());
			int upper = Integer.parseInt(st.nextToken());
			
			int now = Integer.parseInt(st.nextToken());
			int answer = -1;
			if(now < lower){
				answer = lower - now;
			}else if(now <= upper && now >= lower){
				answer =0;
			}
			bw.write("#" + (t+1) + " " +answer +"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
