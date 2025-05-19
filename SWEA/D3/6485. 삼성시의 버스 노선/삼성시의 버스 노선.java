
import java.util.*;
import java.io.*;
public class Solution {
	static List<int[]> range;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			int N = Integer.parseInt(br.readLine());
			
			range = new ArrayList<>();
			for(int i = 0; i < N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				range.add(new int[] {a,b});
			}
			int bus = Integer.parseInt(br.readLine());
			int[] buss = new int[bus];
			for(int i = 0; i < bus; i++){
				buss[i] = Integer.parseInt(br.readLine());
			}
			StringBuilder sb = new StringBuilder();
			int[] answer = checker(range,buss);
			for(int i = 0; i < bus; i++){
				sb.append(answer[i]);
				if(i < bus-1){
					sb.append(" ");
				}
			}
			bw.write("#"+(t+1)+" " + sb.toString()+ "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int[] checker(List<int[]> range, int[] buss){
		int n = buss.length;
		int[] tmp = new int[n];
		
		for(int[] r : range){
			int a = r[0];
			int b = r[1];
			
			for(int i = 0; i < n; i++){
				int target = buss[i];
				if(a <= target && b >= target){
					tmp[i]++;
				}
			}
		}
		return tmp;
	}
}
