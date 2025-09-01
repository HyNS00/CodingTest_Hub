import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        cnt = 0;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(map[r][c] == 'I'){
                    visited[r][c] = true;
                    stack.push(new int[]{r, c});
                    dfs(visited,stack,map);
                }
            }
        }
        String result = cnt > 0 ? String.valueOf(cnt) : "TT";
        bw.write(result);
        bw.close();
        br.close();
    }
    private static void dfs( boolean[][] visited, ArrayDeque<int[]> stack, char[][] map){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while(!stack.isEmpty()){
            int[] curr = stack.pop();

            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && !visited[nx][ny]
                    && map[nx][ny] != 'X') {

                    if(map[nx][ny] == 'P') cnt++;
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;

                }
            }
        }
    }
}
