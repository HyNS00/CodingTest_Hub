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
			int[] snacks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
					.filter(n -> n < M)
					.toArray();
			
			Arrays.sort(snacks);
			int start = 0;
			int end = snacks.length -1;
			int sum = 0;
			while(start < end){
				if(snacks[start] + snacks[end] > M){
					end--;
				}else if(snacks[start] + snacks[end] < M){
					sum = Math.max(sum, snacks[start]+snacks[end]);
					start++;
				}else{
					sum = snacks[start] + snacks[end];
					break;
				}
			}
			int answer = sum > 0 ? sum : -1;
			bw.write("#" + (t+1) + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
