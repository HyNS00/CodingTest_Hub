import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t = 0; t < 10; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int[] arr = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt)
					.toArray();
			
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			for(int i = 0; i < arr.length; i++){
				if(!stack.isEmpty() && stack.peek() == arr[i]){
					stack.pop();
				}else{
					stack.push(arr[i]);
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int num : stack){
				sb.append(num);
			}
			bw.write("#" +(t+1) +" " + sb.reverse().toString()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
