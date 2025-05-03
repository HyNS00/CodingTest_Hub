
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
			
			int answer = checker(arr,n);
			
			bw.write("#"+(i+1)+" " + answer+"\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int checker(int[] arr, int n) {
		int sum = 0;
        for(int i = 2; i < n-2; i++){
        	int curr = arr[i];
            int max = Math.max(Math.max(arr[i-1],arr[i-2]), Math.max(arr[i+1],arr[i+2]));
            
            if(curr > max){
                sum += curr - max;
        	}	
		}
        return sum;
    }
}
