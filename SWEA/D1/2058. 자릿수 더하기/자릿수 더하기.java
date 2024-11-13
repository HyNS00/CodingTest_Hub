import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp = br.readLine();
		String[] arr = tmp.split("");
		int sum = 0;
		for(int i =0; i < arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		bw.write("" + sum);
		bw.flush();
		bw.close();
		br.close();
	}
}
