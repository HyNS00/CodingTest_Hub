

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
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

        int v = Integer.parseInt(br.readLine());

        List<List<Node>> map = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 1; i <= v; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            while(true) {
                int next = Integer.parseInt(st.nextToken());

                if(next == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                map.get(from).add(new Node(next, dist));

            }

        }

        // dfs 2번
        int maxNode = dfs(map,v,1)[1];
        int answer = dfs(map, v, maxNode)[0];
        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
    private static int[] dfs(List<List<Node>> map, int v, int start) {
        int max = 0;
        int maxNode = 0;
        boolean[] visited = new boolean[v + 1];
        visited[start] = true;
        int[] dist = new int[v + 1];
        dist[start] = 0;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(start, 0));
        while (!stack.isEmpty()) {
            Node pop = stack.pop();

            int curr = pop.to;
            int cd = pop.value;

            if(cd > max) {
                max = cd;
                maxNode = curr;
            }

            for (Node next : map.get(curr)) {
                if(!visited[next.to]) {
                    visited[next.to] = true;
                    dist[next.to] = next.value + cd;
                    stack.push(new Node(next.to, dist[next.to]));
                }
            }
        }
        return new int[]{max, maxNode};
    }
}
