
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        // 사이즈를 이미 7까지 받아버림 0 ~ 6 == 7 
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[N+1];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cnt = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                cnt++;

                stack.push(i);

                while(!stack.isEmpty()){
                    int node = stack.pop();

                    if(!visited[node]) {
                        visited[node] = true;

                        for(int tmp : list.get(node)){
                            if(!visited[tmp]) {

                                stack.push(tmp);
                            }
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();

    }

}
