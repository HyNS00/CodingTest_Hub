
import java.util.*;
import java.io.*;
public class Solution {
	static Map<String,Integer> codes = new HashMap<>();
	static List<Integer> list;
	static {
		codes.put("0001101",0);
		codes.put("0011001",1);
		codes.put("0010011",2);
		codes.put("0111101",3);
		codes.put("0100011",4);
		codes.put("0110001",5);
		codes.put("0101111",6);
		codes.put("0111011",7);
		codes.put("0110111",8);
		codes.put("0001011",9);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[N][M];
			
			for(int i = 0; i < N; i++){
				map[i] = br.readLine().toCharArray();
			}
			
			String code = finder(map);
			
			int sum = 0;
			list = new ArrayList<>();
			for(int i = 0,j = 1; i < 56 && j <= 8; i+=7,j++){
				String tmp = code.substring(i,i+7);
				if(j % 2 == 0){
					sum += codes.get(tmp);
				}else{
					sum += codes.get(tmp) * 3;
				}
				list.add(codes.get(tmp));
			}
			int answer = 0;
			if(sum % 10 == 0){
				for(int n : list){
					answer += n;
				}
			}
			bw.write("#" + (t+1) + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static String finder(char[][] map){
		String str = "";
		int start = 0;
		for(int i = 0; i < map.length; i++){
			char[] tmp = map[i];
			for(int j = 0; j < tmp.length; j++){
				if(tmp[j] == '1') {
					start = j;
					str = new String(tmp);
					break;
				}
			}
		}
		int last = str.lastIndexOf("1");
		
		String result = str.substring(start,last+1);
		if(result.length() == 56){
			return result;
		}else{
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 56 - result.length(); i++){
				sb.append("0");
			}
			return sb.append(result).toString();
		}
		
	}
}
