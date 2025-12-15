

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
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
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Node(f, t, v));
        }
        list.sort((a, b) -> a.value - b.value);
        int sum = 0;
        int maxValue = 0;
        for(Node node : list) {
            int a = find(node.from);
            int b = find(node.to);

            if(a != b) {
                union(a,b);
                sum += node.value;
                maxValue = Math.max(maxValue, node.value);
            }
        }
        bw.write(String.valueOf(sum-maxValue));
        bw.close();
        br.close();
    }
    static int find(int n) {
        if(parent[n] == n) {
            return n;
        }

        parent[n] = find(parent[n]);
        return parent[n];
    }
    static void union(int a, int b) {
        if(a > b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }
}
