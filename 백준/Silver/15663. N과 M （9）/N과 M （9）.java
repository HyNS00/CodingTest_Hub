

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int prev = -1; // 직전 값 추적
        for(int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            boolean[] visited = new boolean[n];
            if(prev != arr[i]) {
                list.add(arr[i]);
                prev = arr[i];
                visited[i] = true;
                maker(1,list,m,arr,visited);
            }

        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void maker(int depth, List<Integer> list,int m,int[] arr, boolean[] visited) {
        if(depth == m) {
            for(int n : list) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        int last = -1;
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i] && last != arr[i]) {
                list.add(arr[i]);
                visited[i] = true;
                last = arr[i];
                maker(depth+1,list,m,arr,visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }

        }

    }
}
