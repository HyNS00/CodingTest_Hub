import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {

        int to;
        int value;

        public Node( int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int trial = Integer.parseInt(br.readLine());
        for(int t = 0; t < trial; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            List<List<Node>> nodes = new ArrayList<>();
            // 방향이 없다 -> 양방향
            for(int i = 0; i <= N; i++) {
                nodes.add(new ArrayList<>());
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                nodes.get(from).add(new Node(to, value));
                nodes.get(to).add(new Node(from, value));
            }
            // 방향이 있다 -> 단방향
            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                nodes.get(from).add(new Node(to, value * -1));

            }

            if (!pode(nodes, N)) {
                sb.append("NO");
            }else {
                sb.append("YES");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static boolean pode(List<List<Node>> nodes,int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 0); // 매번 start를 정하지 말고 모든 지점을 0으로 두고
        // 음수 사이클 찾기

        for(int i = 0; i < n-1; i++) {
            for(int j = 1; j <= n; j++) {
                for(Node node : nodes.get(j)) {
                    if (dist[j] + node.value < dist[node.to]) {
                        dist[node.to] = dist[j] + node.value;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(Node node : nodes.get(i)) {
                if (dist[i] + node.value < dist[node.to]) {
                    return true; // 음수 사이클 존재
                }
            }
        }
        return false;
    }
}
