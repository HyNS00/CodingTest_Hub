import java.util.*;
import java.io.*;
public class Solution {
	private static int[] month = {1,2,3,4,5,6,7,8,9,10,11,12};
	private static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {

			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int result = calculate(arr);
			bw.write(String.format("#%d %d\n", test+1,result));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int calculate(int[] arr) {
		int firstM = arr[0];
		int firstD = arr[1];
		int secondM = arr[2];
		int secondD = arr[3];
		
		int cnt = secondM -firstM;
		int answer = 0;
		if(cnt > 0) {
			for(int i = firstM; i < secondM-1; i++) {
				answer += days[i];
			}
			int maxDay = days[firstM-1];
			answer += maxDay - firstD + secondD;
		}else {
			answer += (secondD - firstD);
		}
		
		
		return answer+1;
	}
}
