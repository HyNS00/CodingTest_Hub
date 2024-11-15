import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t= Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			Map<Integer,Integer> map = new HashMap<>();
			int i = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 1000; j++) {
				int k =Integer.parseInt(st.nextToken());
				map.put(k, map.getOrDefault(k,0)+1);
			}
		
			int max = Collections.max(map.values());
			List<Integer> list = map.entrySet().stream().filter(entry -> entry.getValue() == max).map(Map.Entry::getKey)
				.collect(Collectors.toList());
			int answer = Collections.max(list);
			bw.write(String.format("#%d %d\n",i,answer));
			
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}