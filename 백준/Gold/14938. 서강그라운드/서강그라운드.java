
import java.io.*;
import java.util.*;

public class Main {
    static int maxItem = Integer.MIN_VALUE;
    static class Node {
        int to;
        int value;

        public Node( int to, int value) {
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
        int r = Integer.parseInt(st.nextToken());

        List<List<Node>> map = new ArrayList<>();
        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.get(from).add(new Node(to, value));
            map.get(to).add(new Node(from, value));
        }

        for(int i = 1; i <= n; i++) {
          maxItem = Math.max(maxItem,bfs(i, map, m, items));
        }
        bw.write(String.valueOf(maxItem));
        bw.close();
        br.close();
    }
    static int bfs(int startIdx, List<List<Node>> map, int limit,int[] items) {
        int[] dist = new int[items.length+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);

        pq.add(new Node(startIdx, 0));
        dist[startIdx] = 0;
        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            for (Node next : map.get(curr.to)) {
                int nextIdx = next.to;
                int nextValue = next.value + curr.value;
                if(dist[nextIdx] > nextValue && nextValue <= limit) {
                    dist[nextIdx] = nextValue;
                    pq.add(new Node(nextIdx, nextValue));
                }
            }
        }
        int totalItems = 0;
        for(int i = 1; i < dist.length; i++) {
            if(dist[i] <= limit) {
                totalItems += items[i];
            }
        }
        return totalItems;
    }
}
