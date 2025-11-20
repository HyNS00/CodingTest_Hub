
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Node>> map = new ArrayList<>();
        List<List<Node>> reverse = new ArrayList<>();
        // 가는 방향, 돌아오는 방향 두 번 구한다
        // 다익스트라 지만 양방향 노드로 진행
        for(int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.get(from).add(new Node(to,value));
            reverse.get(to).add(new Node(from, value));
        }
        int[] toParty = dikstra(map, n, x);
        int[] toHome = dikstra(reverse, n, x);

        int result = 0;

        for(int i = 1; i <= n; i++) {
            if(toHome[i] == Integer.MAX_VALUE || toParty[i] == Integer.MAX_VALUE) continue;
            result = Math.max(result, toHome[i] + toParty[i]);
        }

        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
    public static int[] dikstra(List<List<Node>> graph, int n, int start) {
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);

        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currIdx = node.to;
            int currValue = node.value;

            if(dist[currIdx] < currValue) continue;

            for (Node next : graph.get(currIdx)) {
                int nextIdx = next.to;
                int nextValue = currValue + next.value;

                if(dist[nextIdx] > nextValue) {
                    dist[nextIdx] = nextValue;
                    pq.add(new Node(nextIdx, nextValue));
                }
            }
        }
        return dist;
    }
}
