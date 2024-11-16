import java.util.*;
import java.io.*;
public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			Map<String,Integer> map = new LinkedHashMap<>();
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int cnt = Integer.parseInt(st.nextToken());
				map.put(str, cnt);
			}
			String answer = print(map);
			bw.write(String.format("#%d\n%s\n", test+1,answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static String print(Map<String,Integer> map) {
		StringBuilder sb= new StringBuilder();
		int len = 0;
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			int cnt = entry.getValue();
			for(int i = 0; i < cnt; i++) {
				sb.append(entry.getKey());
				len++;
                if(len == 10) {
					sb.append("\n");
					len = 0;
				}
			}
		}
		return sb.toString();
	}
}
