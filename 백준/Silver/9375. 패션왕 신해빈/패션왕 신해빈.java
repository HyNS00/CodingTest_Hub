

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){

            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String category = st.nextToken();

                map.put(category, map.getOrDefault(category,0)+1);
            }
            int sum = 1;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                int tmp = entry.getValue()+1;
                sum *= tmp;
            }
            sb.append(sum-1).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
