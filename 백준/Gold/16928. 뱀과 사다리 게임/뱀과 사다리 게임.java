
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < ladder+snake; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map.put(from,to);
        }

        int[] gameMap = new int[101];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        int[] visited = new int[101];
        // 시작포인트 잘보기
        queue.add(new int[]{1, 0});
        // 적어도 2개의 배열을 사용하자 -> 역할 분리
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();

            int curr = tmp[0];
            if(curr == 100) {
                break;
            }
            int cnt = tmp[1];

            for(int i = 1; i <= 6; i++){
                int next = curr + i;
                if(next <= 100 && visited[next] == 0) {
                    if(map.getOrDefault(next,0) != 0) {
                        next = map.get(next);
                    }
                    visited[next] = 1;
                    queue.add(new int[] {next, cnt+1});
                    gameMap[next] = cnt+1;
                }
            }

        }
        bw.write(String.valueOf(gameMap[100]));
        bw.close();
        br.close();
        
        
        
    }

}
