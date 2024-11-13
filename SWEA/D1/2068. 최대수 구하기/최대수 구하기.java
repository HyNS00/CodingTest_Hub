

import java.util.*;
import java.io.*;

public class Solution  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++){
			int answer = 0;
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++){
				list.add(Integer.parseInt(st.nextToken()));
			}
			answer = Collections.max(list);
			bw.write("#"+(i+1)+" " +answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
