
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // IntStream.rangeClosed()
        // IntStream.range() 

        int[] arr = IntStream.rangeClosed(1, n).toArray();

        boolean[] visited = new boolean[n];

        for(int i = 0; i <= n-m; i++){
            List<Integer> list = new ArrayList<>();
            visited[i] = true;

            list.add(arr[i]);
            recur(list, visited, n, m, i, arr);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    public static void recur(List<Integer> list , boolean[] visited,int n,int m, int start, int[] arr) {
        if(list.size() == m) {
            for(int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start+1; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                recur(list, visited, n, m, i, arr);
                list.remove(list.size() - 1);
                // visited말고 list에서 제거해주는거 잊지말자
                visited[i] = false;
            }
        }
    }

}
