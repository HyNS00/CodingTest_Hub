import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
	static Map<String,Integer> strToInt = new HashMap<>();
	static Map<Integer,String> intToStr = new HashMap<>();
	static String[][] standard ={{"ZRO", "0"},{"ONE","1"},{"TWO","2"},
			{"THR","3"},{"FOR","4"},{"FIV","5"},{"SIX","6"},{"SVN","7"},{"EGT","8"},{"NIN","9"}};
	static{
		for(int i = 0; i < standard.length; i++){
			strToInt.put(standard[i][0], Integer.parseInt(standard[i][1]));
			intToStr.put(Integer.parseInt(standard[i][1]), standard[i][0]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			int len = Integer.parseInt(st.nextToken());
			String[] arr = br.readLine().split(" ");
			int[] tmp = new int[arr.length];
			for(int i = 0; i < arr.length; i++){
				tmp[i] = strToInt.get(arr[i]);
			}
			Arrays.sort(tmp);
			
			
			String answer = Arrays.stream(tmp).mapToObj(num -> intToStr.get(num))
				.collect(Collectors.joining(" "));
			
			bw.write("#"+(t+1)+"\n" + answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
