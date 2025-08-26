
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int set = Integer.parseInt(br.readLine());

        List<List<Integer>> computers = new ArrayList<>();
        for(int i = 0; i < t; i++){
            computers.add(new ArrayList<>());
        }

        StringTokenizer st;

        for(int i = 0; i < set; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) -1;
            computers.get(first).add(second);
            computers.get(second).add(first);
        }
        cnt = 0;
        boolean[] visited = new boolean[computers.size()];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int c : computers.get(0)){
            stack.push(c);
        }
        visited[0] = true;
        dfs(computers,visited,stack);
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
    private static void dfs(List<List<Integer>> computers, boolean[] visited,ArrayDeque<Integer> stack) {
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            if(!visited[tmp]) {
                visited[tmp] = true;
                cnt++;
                for(int c :computers.get(tmp)) {
                    if(!visited[c]){
                        stack.push(c);
                    }
                }
            }
        }
    }
}
