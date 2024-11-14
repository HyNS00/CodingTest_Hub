import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
					.sorted().collect(Collectors.toList());
			int max = Collections.max(list);
			int min = Collections.min(list);
			
			double sum = (double) list.stream().filter(x -> x > min && x < max).mapToInt(x -> x).sum() /8.0;
			
			bw.write(String.format("#%d %d\n", test+1, Math.round(sum)));
					
		}
		bw.flush();
		bw.close();
		br.close();
	}
}