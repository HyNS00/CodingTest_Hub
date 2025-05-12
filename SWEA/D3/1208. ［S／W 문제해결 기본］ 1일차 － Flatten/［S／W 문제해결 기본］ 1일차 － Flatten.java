
import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int t = 0; t < 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x))
					.toArray();
			Arrays.sort(arr);
			int answer = checker(dump, arr);
			
			bw.write("#"+(t+1)+" " + answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int checker(int dump, int[] arr) {
		int n = arr.length;
		for(int i = 0; i < dump; i++) {
			if(arr[n-1] - arr[0] == 1) {
				return arr[n-1] - arr[0];
			}
			arr[n-1]--;
			arr[0]++;
			Arrays.sort(arr);
		}
		return arr[n-1]-arr[0];
	}
}
