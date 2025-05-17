
import java.util.*;
import java.io.*;
public class Solution {
	static List<List<Integer>> list;
	static int maxValue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			for(int i = 0; i <= n; i++){
				list.add(new ArrayList<>());
			}
			
			for(int j = 0; j < m; j++){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.get(x).add(y);
				list.get(y).add(x);
			}
			maxValue = 0;
			
			for(int k = 1; k <= n; k++){
				boolean[] visited = new boolean[n+1];
				dfs(k,1,visited);
			}
			
			bw.write("#"+(t+1)+" "+maxValue+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int curr, int length, boolean[] visited){
		visited[curr] = true;
		maxValue = Math.max(maxValue, length);
		
		for(int next : list.get(curr)){
			if(!visited[next]){
				dfs(next,length+1,visited);
			}
		}
		
		visited[curr] = false;
	}
}
