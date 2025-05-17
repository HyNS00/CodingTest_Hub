
import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
					.toArray();
			int answer = checker(arr);
			bw.write("#"+(t+1)+" "+ answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int checker(int[] arr){
		int max = -1;
		int n = arr.length;
		if(n == 1){
			if(arr[0] % 10 != 0 && isPossible(arr[0])){
				return arr[0];
			}else{
				return max;
			}
		}
		Arrays.sort(arr);
		for(int i = n-1; i >= 1; i--){
			for(int j= i-1; j >= 0; j--){
				int result = arr[i] * arr[j];
				if(result % 10 != 0 && isPossible(result)) {
					max = Math.max(max, result);
				}
			}
		}
		return max;
	}
	private static boolean isPossible(int num) {
        int prevDigit = 10; // 어떤 자릿수보다 항상 큰 초기값
        while (num > 0) {
            int currDigit = num % 10;
            if (currDigit > prevDigit) return false;
            prevDigit = currDigit;
            num /= 10;
        }
        return true;
    }
}
