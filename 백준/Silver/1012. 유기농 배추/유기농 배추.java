
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[][] map = new int[M][N];
            boolean[][] visited = new boolean[M][N];
            int K = Integer.parseInt(st.nextToken());

            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }
            cnt = 0;
            ArrayDeque<int[]> stack = new ArrayDeque<>();

            for(int r = 0; r < map.length; r++){
                for(int c = 0; c < map[0].length; c++){
                    if(map[r][c] != 0 && !visited[r][c]){
                        stack.push(new int[] {r,c});
                        cnt++;
                        dfs(map, visited,stack);
                    }
                }
            }
            sb.append(String.valueOf(cnt)).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static void dfs(int[][] map, boolean[][] visited,ArrayDeque<int[]> stack){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!stack.isEmpty()){
            int[] curr = stack.pop();

            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] != 0
                        && !visited[nx][ny]) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
