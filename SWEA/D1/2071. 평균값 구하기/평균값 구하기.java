import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Solution {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++){
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
				sum += Integer.parseInt(st.nextToken());
			}
            int answer = (int) Math.round(sum/10.0);
			bw.write("#"+(i+1)+" "+ answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
