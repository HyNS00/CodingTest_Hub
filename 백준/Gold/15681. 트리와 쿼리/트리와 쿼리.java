

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int tr = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] parent = new int[n + 1];
        int[] subtree = new int[n + 1];

        for(int i = 0; i <= n; i++ ){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        init(root, graph, parent, subtree);
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < tr; t++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(subtree[q]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void init(int root, List<List<Integer>> graph, int[] parent, int[] subtree) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> subStack = new ArrayDeque<>();

        boolean[] visited = new boolean[parent.length];
        visited[root] = true;
        stack.push(root);

        while(!stack.isEmpty()) {
            int curr = stack.pop();
            subStack.push(curr);
            for (int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[next] = curr;
                    stack.push(next);
                }
            }
        }

        while (!subStack.isEmpty()) {
            int currNode = subStack.pop();

            int size = 1;

            for (int nextNode : graph.get(currNode)) {
                if(parent[nextNode] == currNode) {
                    size += subtree[nextNode];
                }
            }
            subtree[currNode] = size;
        }

    }
}
