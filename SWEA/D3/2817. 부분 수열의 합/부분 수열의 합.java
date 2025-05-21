import java.util.*;
import java.io.*;
public class Solution {
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			cnt = 0;
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
					.filter(x ->  x <= M)
					.toArray();
			
			Arrays.sort(arr);
			back(arr,0,M,0);
			
			bw.write("#" + (t+1) + " " + cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void back(int[] arr, int idx, int target, int sum){
		if(idx == arr.length){
			if(sum == target) cnt++;
			return;
		}
		if(sum > target) return;
		
		back(arr, idx+1, target, sum + arr[idx]);
		back(arr,idx+1,target, sum);
	}
}
