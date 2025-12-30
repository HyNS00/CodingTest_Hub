import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int k;
    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            Node[] nodes = new Node[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                int value = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(i, value);
            }
            int[] indegree = new int[n + 1];
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                indegree[second]++;
                list.get(first).add(second);
            }

            ArrayDeque<Node> queue = new ArrayDeque<>();
            int[] dp = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                if(indegree[i] == 0) {
                    queue.add(nodes[i]);
                }
                dp[i] = nodes[i].value;
            }
            int target = Integer.parseInt(br.readLine());
            while(!queue.isEmpty()) {
                Node poll = queue.poll();
                for(int next : list.get(poll.idx)){
                    indegree[next]--;
                    dp[next] = Math.max(dp[next], dp[poll.idx] + nodes[next].value);
                    if(indegree[next] == 0) {
                        queue.add(nodes[next]);
                    }
                }

            }
            sb.append(dp[target]).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
