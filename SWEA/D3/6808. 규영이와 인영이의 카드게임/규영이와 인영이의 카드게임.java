import java.util.*;
import java.io.*;
public class Solution {
	static int[] in = new int[9];
	static boolean[] ori;
	static int[] cards = new int[9];
	static int win;
	static int lose;
	static {
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			int[] g = new int[9];
			ori = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++){
				int num = Integer.parseInt(st.nextToken());
				g[i] = num;
				ori[num] = true;
			}
			int idx = 0;
			for(int i = 1; i < 19; i++){
				if(!ori[i]){
					in[idx] = i;
					idx++;
				}
			}
			win = 0;
			lose = 0;
			boolean[] visited = new boolean[9];
			perm(0,visited,g);
			
			bw.write("#" + (t+1) + " " + win+" "+lose+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void perm(int depth,boolean[] visited,int[] g){
		if(depth == 9){
			checker(g);
			return;
		}
		
		for(int i = 0; i < 9; i++){
			if(!visited[i]){
				visited[i] = true;
				cards[depth]  = in[i];
				perm(depth+1, visited,g);
				visited[i] = false;
			}
		}
	}
	private static void checker(int[] g){
		int guSum = 0;
		int inSum = 0;
		for(int i = 0; i < 9; i++){
			int guC = g[i];
			int inC = cards[i];
			
			if(guC > inC){
				guSum += guC+inC;
			}else{
				inSum += guC + inC;
			}
		}
		if(guSum > inSum) {
			win++;
		}else if(guSum < inSum){
			lose++;
		}
	}
}