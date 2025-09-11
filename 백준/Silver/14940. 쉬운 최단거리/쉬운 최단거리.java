
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] target = new int[2];
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer  st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] result = new int[n][m];
        int[][] map = new int[n][m];
        for(int[] tmp :result) {
            Arrays.fill(tmp,-1); // 못 가는 거 미리 -1
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    target[0] = i;
                    target[1] = j;
                    result[i][j] = 0;
                }
                if(map[i][j] == 0){
                    result[i][j] = 0;
                }
            }
        }
//         bfs -> 잘못 생각한 점 : 시작점에서 출발한다.
//         모든 점에서 2까지의 거리보다 모든 점에서 도착하는 것도 좋지만, 2에서 출발하는 것도 마찬가지다.
        queue.add(new int[]{target[0], target[1]});
        bfs(result,queue,map);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static void bfs(int[][] visited, ArrayDeque<int[]> queue, int[][] map){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            int currX = curr[0];
            int currY = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + currX;
                int ny = dy[i] + currY;

                if(nx >= 0 && ny >= 0 && ny < map[0].length && nx < map.length && visited[nx][ny] == -1 &&
                        map[nx][ny] != 0) {
                    visited[nx][ny] = visited[currX][currY] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
