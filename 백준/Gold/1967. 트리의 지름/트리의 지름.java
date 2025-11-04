import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<List<int[]>> map = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.get(from).add(new int[]{to, value});
            map.get(to).add(new int[]{from, value});

        }

        // 루트 노드에서부터 가장 먼 거리 노드를 구한다.
        int[] maxNode = dfs(1,map,n);

        // 해당 노드로부터 가장 먼 노드까지의 거리를 구한다.
        int[] maxDiameter = dfs(maxNode[0], map, n);

        bw.write(String.valueOf(maxDiameter[1]));
        bw.close();
        br.close();
    }

    private static int[] dfs(int startIdx, List<List<int[]>> map, int n) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.add(new int[]{startIdx, 0});
        int maxDist = 0;
        int maxIdx = startIdx;
        boolean[] visited = new boolean[n + 1];
        visited[startIdx] = true;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int currIdx = pop[0];
            int currDist = pop[1];

            if (maxDist < currDist) {
                maxDist = currDist;
                maxIdx = currIdx;
            }
            for (int[] next : map.get(currIdx)) {
                int nextIdx = next[0];
                int nextValue = next[1];

                if (!visited[nextIdx]) {
                    visited[nextIdx] = true;
                    stack.push(new int[]{nextIdx, currDist + nextValue});
                }
            }
        }
        return new int[]{maxIdx, maxDist};
    }
}
