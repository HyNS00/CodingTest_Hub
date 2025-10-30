
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        private int number;
        private int value;

        public Node(int number, int value) {
            this.number = number;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node(int number) {
            this.number = number;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());
        List<List<Node>> nodes = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // from to v

            nodes.get(from).add(new Node(to, v));
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.value)); //람다로
        pq.add(new Node(startNode, 0));
        dist[startNode] = 0;
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(dist[curr.number] < curr.value) continue;
            
            for(Node next : nodes.get(curr.number)) {

                if(dist[next.number] > dist[curr.number] + next.value) {
                    dist[next.number] = dist[curr.number] + next.value;

                    pq.add(new Node(next.number, dist[next.number]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            }else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
