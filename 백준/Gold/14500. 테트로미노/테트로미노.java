import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        max = 0;
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }
        boolean[][] visited = new boolean[n][m];
        // dfs + 백트래킹

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true;
                dfs(i,j,1,map[i][j],visited,map);
                visited[i][j] = false;
            }
        }
        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
    static void dfs(int x, int y, int count , int sum, boolean[][] visited, int[][] map) {
        if(count == 4) {
            max = Math.max(max,sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                if(count == 2) {
                    dfs(x,y,count+1,sum+map[nx][ny],visited,map);
                    visited[nx][ny] = false;
                }

                dfs(nx,ny,count+1,sum + map[nx][ny], visited,map);
                visited[nx][ny]= false;
            }
        }
    }
}
