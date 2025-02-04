import java.util.*;
class Solution {
   public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        queue.offer(new int[] {0,0});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < n && nx >= 0 && ny < m && ny >= 0){
                    if(maps[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1;

                        queue.offer(new int[] {nx,ny});
                    }
                }
            }
        }

        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }
}