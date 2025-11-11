import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;

        int[] visited = new int[100001];

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.add(new int [] {n, 0});
        int minTime = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curr = poll[0];
            int time = poll[1];

            if(curr == k) {
                if(visited[curr] == 0){
                    minTime = time; // 최적 시간을 체크해준다.
                    cnt++;
                }else if(visited[curr] == time) {
                    cnt++; // 최적시간과 같은 경우에만 값을 올린다.
                }
                continue;
            }


            int[] jump = {curr +1, curr -1, curr * 2};

            for(int i = 0; i < 3; i++) {

                int next = jump[i];
                if(next < 0 || next > 100000) continue;

                if(visited[next] == 0 || visited[next] >= visited[curr] + 1) {
                    // 첫 방문 이거나 , 방문 값이 같을 때
                    visited[next] = visited[curr]+1;
                    queue.add(new int[] {next, visited[next]});
                }
            }

        }

        String answer = visited[k] + "\n" + cnt;
        bw.write(answer);
        bw.close();
        br.close();
    }
}
