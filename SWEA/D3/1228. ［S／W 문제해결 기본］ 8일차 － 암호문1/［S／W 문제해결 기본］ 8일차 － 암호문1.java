import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution{
		public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int t = 0; t < 10; t++){
			int N = Integer.parseInt(br.readLine());
			
			List<Integer> list = Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt).collect(Collectors.toList());
			
			int M = Integer.parseInt(br.readLine());
			
			
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++){
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				List<Integer> tmp = new ArrayList<>();
				
				for(int j = 1; j <=y; j++){
					tmp.add(Integer.parseInt(st.nextToken()));
				}
				list.addAll(x,tmp);
			}
			for(int i = 0; i < 10; i++){
				sb.append(list.get(i));
				if(i < 9){
					sb.append(" ");
				}
			}
			
			bw.write("#" + (t+1) + " "+ sb.toString()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
