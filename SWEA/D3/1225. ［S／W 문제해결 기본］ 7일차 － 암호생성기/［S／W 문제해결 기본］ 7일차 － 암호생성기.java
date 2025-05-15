import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t = 0; t < 10; t++){
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
					.toArray();
			int[] answer = checker(arr);
			
			sb = new StringBuilder();
			
			for(int i = 0; i < 7; i++){
				sb.append(answer[i]).append(" ");
			}
			sb.append(answer[7]);
			
			bw.write("#"+(t+1)+ " " +sb.toString()+ "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int[] checker(int[] arr){
		
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		for(int n : arr){
			queue.add(n);
		}
		
		boolean flag = true;
		int cnt = 1;
		int idx = 0;
		while(flag){
			
			int tmp = queue.poll();
			
			tmp -= cnt;
			
			if(tmp <= 0){
				tmp = 0;
				queue.add(tmp);
				flag = false;
			}
			
			queue.add(tmp);
			cnt++;
			if(cnt == 6){
				cnt = 1;
			}
			
		}
		return queue.stream().mapToInt(Integer::intValue).toArray();
	}
}
