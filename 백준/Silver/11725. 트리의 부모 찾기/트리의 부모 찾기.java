
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        visited[1] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    // 부모를 어떻게 찾아갈까?
                    // 업데이트할 때 해당 부모를 fix하고 건들지 않는다.
                    parent[next] = curr;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
