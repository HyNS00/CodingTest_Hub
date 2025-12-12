

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] parent;
    static class Node {
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for(int i = 0; i <= V; i++) {
            parent[i] = i;
        }
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            nodes.add(new Node(from, to, value));
        }
        nodes.sort(Comparator.comparingInt((Node node) -> node.value));
        int result = 0;
        for(Node node : nodes) {
            int a = find(node.from);
            int b = find(node.to);

            if(a != b) {
                union(a, b);
                result += node.value;
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
    static int find(int n) {
        if(parent[n] == n) return n;
        int root = find(parent[n]);
        parent[n] =root;
        return root;
    }

    static void union(int n1, int n2) {
        if(n1 > n2) {
            parent[n1] = n2;
        }
        else {
            parent[n2] = n1;
        }
    }
}
