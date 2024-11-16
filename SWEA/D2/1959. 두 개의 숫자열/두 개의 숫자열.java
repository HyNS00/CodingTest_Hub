import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int answer = 0;
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(n < m) {
				answer = check(b,a);
			}else {
				answer = check(a,b);
			}
			bw.write(String.format("#%d %d\n",test+1,answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int check(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;
		int max = 0;
		
		for(int i = 0; i < n-m+1; i++) {
			int sum = 0;
			for(int j = 0; j < m; j++) {
				sum += a[i+j] * b[j]; 
			}
			max = Math.max(sum,max);
		}
		return max;
	}
}