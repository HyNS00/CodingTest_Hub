
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

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> map = new ArrayList<>();
        for(int i =0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map.get(from).add(to);
            indegree[to]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            sb.append(poll).append(" ");

            for(int next : map.get(poll)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    // 진입 차수가 0이 되었을 때 넣어서 그 자식을 살펴봄
                    queue.add(next);
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
