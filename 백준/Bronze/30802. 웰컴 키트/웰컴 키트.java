import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int tSet = 0;
		int adj = t-1;
		for(int candi : arr){
			tSet += (candi + adj) / t;
		}
		int pSet = n / p;
		int pOne = n % p;
		
		bw.write(tSet + "\n"  + pSet + " "  + pOne);
		bw.flush();
		bw.close();
		br.close();
	}
}
