
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st  = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            boolean[] visited = new boolean[n];
            visited[i] = true;
            maker(m, list, 1, visited, arr);

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    public static void maker(int m, List<Integer> list, int depth, boolean[] visited, int[] arr) {
        if(depth == m) {
            for(int n : list) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                maker(m,list,depth+1,visited,arr);

                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
