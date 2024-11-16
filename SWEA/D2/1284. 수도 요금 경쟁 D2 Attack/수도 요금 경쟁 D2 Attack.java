import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int answer = calculate(arr);
			bw.write(String.format("#%d %d\n",test+1,answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int calculate(int[] tmp) {
		int p = tmp[0];
		int q = tmp[1];
		int r = tmp[2];
		int s = tmp[3];
		int w = tmp[4];
		int A = p * w;
		int B = 0;
		if(w > r) {
			B = q + (w-r) * s ;
		}else {
			B = q;
		}
		return (A > B) ? B : A;
	}
}
