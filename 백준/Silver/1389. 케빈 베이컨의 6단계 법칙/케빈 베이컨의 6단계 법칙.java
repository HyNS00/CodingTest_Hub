
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a - 1).add(b -1);
            list.get(b-1).add(a-1);
        }

        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int[] visited = new int[N];
            Arrays.fill(visited,-1);
            visited[i] = 0;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.add(i);
            // bfs로 접근해보자
            int cnt = dfs(visited,stack, list);

            result.add(new int[] {i+1, cnt});
        }
        // 배열 일 때 comparingInt기억해 둘 것
        Comparator<int[]> comp = Comparator.comparingInt((int[] a) -> a[1])
                .thenComparingInt((int[] a) -> a[0]);
        //다른 방법
        /**
         *
         * (a,b) -> {
         *        if(a[0] != b[0]) {
         *         return Integer.compare(a[1],b[1]);
         *         }
         *      else {
         *           return Integer.compare(a[0],b[0])
         *       }
         */

        result.sort(comp);
        int answer = result.get(0)[0];

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
    private static int dfs(int[] visited, ArrayDeque<Integer> stack, List<List<Integer>> list){
        while(!stack.isEmpty()) {
            int curr = stack.poll();
            List<Integer> tmp = list.get(curr);

            for(int next : tmp){
                if(visited[next] == -1) {
                    visited[next] = visited[curr] +1;
                    stack.add(next);
                }
            }
        }
        return Arrays.stream(visited).sum();
    }
}
