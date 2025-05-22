import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int answer = checker(arr);
			
			
			bw.write("#" + (t+1) +" "+ answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int checker(int[] arr){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for(int i = 1; i < arr.length; i++){
			int idx = Collections.binarySearch(list, arr[i]);
			
			if(idx < 0){
				idx = -idx;
			}
			
			if(idx -1 == list.size()){
				list.add(arr[i]);
			}else{
				list.set(idx-1, arr[i]);
			}
		}
		return list.size();
	}
}
