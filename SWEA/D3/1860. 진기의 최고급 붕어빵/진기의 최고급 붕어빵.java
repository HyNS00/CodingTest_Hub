
import java.util.*;
import java.io.*;
public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] boolong = new int[3];
			for(int i = 0; i < 3; i++){
				boolong[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			int[] person = new int[boolong[0]];
			
			for(int i = 0; i < person.length; i++){
				person[i] = Integer.parseInt(st.nextToken());
			}
			String answer = checker(boolong,person) ? "Possible" : "Impossible";
			bw.write("#"+(t+1)+" "+ answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean checker(int[] boolong, int[] person){
		int bread = 0;
		int N = boolong[0];
		int M = boolong[1];
		int K = boolong[2];
		int time = 0;
		Arrays.sort(person);
		int idx = 0;
		boolean flag = true;
		if(person[0] == 0){
			return false;
		}
		
		for(int i = 1; i <= person[N-1]; i++){
			if(i % M == 0){
				bread += K;
			}
			
			if(i == person[idx]){
				if(bread <= 0){
					flag = false;
					break;
				}else{
					idx++;
					bread--;
				}
			}
		}
		return flag;
	}
}
