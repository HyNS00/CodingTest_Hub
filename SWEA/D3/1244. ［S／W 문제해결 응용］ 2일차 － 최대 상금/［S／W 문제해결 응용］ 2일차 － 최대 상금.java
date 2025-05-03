
	
	import java.util.*;
	import java.io.*;
	public class Solution {
		static int maxValue;
		static Set<String> set;
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int T = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < T; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				String target = st.nextToken();
				maxValue = 0;
				int count = Integer.parseInt(st.nextToken());
				set = new HashSet<>();
				dfs(target.toCharArray(),count,0);
				
				bw.write("#"+(i+1)+" " + maxValue + "\n");
			}
			bw.flush();
			bw.close();
			br.close();
		}
		
		public static void dfs(char[] arr, int count, int curr) {
			if(curr == count) {
				int value = Integer.parseInt(new String(arr));
				maxValue = Math.max(value,maxValue);
				return;
			}
			
			String key = new String(arr);
			if(set.contains(key)) {
				return;
			}
			
			set.add(key);
			
			for(int i = 0; i < arr.length -1; i++) {
				for(int j = i+1; j < arr.length; j++) {
					swap(arr,i,j);
					dfs(arr,count,curr+1);
					// 원상 복구 하는 것이므로 그냥 같은 위치를 하면 되돌아온다.
					swap(arr,i,j);
				}
			}
			
		}
		public static void swap(char[] arr, int i , int j) {
			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
