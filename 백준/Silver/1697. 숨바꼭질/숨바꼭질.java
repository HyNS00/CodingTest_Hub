
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

//        boolean[] visited = new boolean[M + 1];
        int[] result = new int[100001];
        Arrays.fill(result, -1);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {N,0});
        bfs(queue,result);

        int answer = result[M];
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
    private static void bfs(ArrayDeque<int[]> queue, int[] result) {
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();

            int curr = tmp[0];
            
            int cnt = tmp[1];

            if(result[curr] != -1) {
                continue;
                // 이미 bfs로 방문햇다면 가장 작은 값
            }
            result[curr] = cnt;
            int[] dn = {curr*2, curr -1, curr +1};
            for(int i = 0; i < 3; i++) {
                if((dn[i] < 0) || dn[i] > 100000){
                    continue;
                }
                queue.add(new int[] {dn[i], cnt+1});
            }


        }
    }
}
