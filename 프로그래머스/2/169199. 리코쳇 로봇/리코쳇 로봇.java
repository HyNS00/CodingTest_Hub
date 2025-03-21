import java.util.*;
import java.util.stream.*;
class Solution {
    // 최소 루트 -> bfs 
    // 미끄러진다 -> 한쪽 방향으로만 지속적으로 움직인다.
    public int solution(String[] board) {
        char[][] map = Arrays.stream(board).map(String::toCharArray)
            .toArray(char[][]::new);
        int n = map.length;
        int m = map[0].length;
        
        boolean[][] visited = new boolean[n][m];
        // 미끄러지더라도, 무한루프를 방지하기 위해 사용하자
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'R'){
                    answer = bfs(map,visited, i,j,0);
                }
            }
        }
        return answer;
    }

    public int bfs(char[][] map , boolean[][] visited, int x, int y, int v){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x,y,v});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cv = curr[2];
            if(map[cx][cy] == 'G'){
                return cv;
            }
            
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            
            for(int i = 0; i < 4; i++){
                // 시작 포인트
                int nx = cx;
                int ny = cy;
                while(true){
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if(tx < 0 || tx >= map.length || ty < 0 || ty >= map[0].length
                      || map[tx][ty] == 'D'){
                        break;
                    }
                    // 갱신
                    nx = tx;
                    ny = ty;
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx,ny,cv+1});
                }
            }
        }
        return -1;
    }
}