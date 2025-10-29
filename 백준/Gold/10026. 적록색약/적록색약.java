

import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[n][n];
        int standard = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    standard++;
                    dfsOriginal(map, visited, i, j, map[i][j]);
                }
            }
        }
        visited = new boolean[n][n];
        int no = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    no++;
                    dfs(map, visited, i, j, map[i][j]);
                }
            }
        }
        bw.write(standard+ " " + no);
        bw.close();
        br.close();
    }
    private static void dfsOriginal(char[][] map, boolean[][] visited, int x,int y, char color){
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] dx = {0, 1, -1, 0};
        int[] dy = {-1, 0, 0, 1};
        stack.add(new int[]{x, y});
        while(!stack.isEmpty()){
            int[] curr = stack.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < map.length && ny < map.length &&
                        !visited[nx][ny] && map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    stack.add(new int[]{nx, ny});
                }
            }
        }

    }
    private static void dfs(char[][] map, boolean[][] visited, int x,int y, char color) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] dx = {0, 1, -1, 0};
        int[] dy = {-1, 0, 0, 1};
        stack.add(new int[]{x, y});
        while(!stack.isEmpty()){
            int[] curr = stack.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < map.length && ny < map.length &&
                        !visited[nx][ny] && redGreen(color, map[nx][ny])) {
                    visited[nx][ny] = true;
                    stack.add(new int[]{nx, ny});
                }
            }
        }
    }
    private static boolean redGreen(char red, char green) {
        if((red == 'R' || red == 'G') && (green == 'R' || green == 'G')) {
            return true;
        }
        return red == green; // 그외는 둘이 비교
    }
    // 중요 red가 R 또는 G  &&
}
