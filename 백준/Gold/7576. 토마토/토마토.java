import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[][] box = new int[row][col];

        for(int r = 0; r < row; r++){
            box[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();

        }
        // 한번에 실행하기  + 하나의 map에는 하나의 역할만 부여

        int[][] visited =new int[row][col];

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                if(box[i][j] == 1) {
                    queue.add(new int[]{i, j});

                }
            }
        }

        bfs(queue,box,visited);
        int cnt = 0;
        boolean flag = true;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                if(box[i][j] == 0) {
                    cnt = -1;
                    flag = false;
                    break;
                }
                cnt = Math.max(cnt, visited[i][j]);
            }
            if(!flag) break;
        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();

    }
    private static void bfs(ArrayDeque<int[]> queue, int[][] map, int[][] visited) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length
                        && map[nx][ny] == 0) {
                    map[nx][ny] = 1; // 방문처리
                    // map에 방문처리 역할을 맡긴다
                    visited[nx][ny] =visited[cx][cy] +1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }


}
