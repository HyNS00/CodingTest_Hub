import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < tmp.length; j++) {
                if (tmp[j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int[] visited = new int[n];

            stack.push(i);

            int[] result = dfs(stack,visited,graph);

            Arrays.stream(result).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static int[] dfs(ArrayDeque<Integer> stack, int[] visited, List<List<Integer>> graph) {
        while(!stack.isEmpty()) {
            int tmp = stack.pop();

            List<Integer> list = graph.get(tmp);
            for(int num : list) {
                if(visited[num] == 0) {
                    visited[num] = 1;
                    stack.push(num);
                }
            }
        }
        return visited;
    }
}
