import java.util.*;
class Solution {
    public int solution(String[] maps) {
        // 최대한 빠르게 -> bfs
        int answer = 0;
        char[][] maze = new char[maps.length][];
        for(int i = 0; i < maps.length; i++){
            maze[i] = maps[i].toCharArray();
        }
        int  n = maps.length;
        int  m = maps[0].length();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 'S'){
                    int tmp = bfs(maze,'L',i,j);
                    if(tmp == -1){
                        return -1;
                    }else{
                        answer += tmp;
                        break;
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 'L'){
                    int tmp = bfs(maze,'E',i,j);
                    if(tmp == -1){
                        return -1;
                    }else{
                        answer += tmp;
                        break;
                    }
                }
            }
        }
        return answer;
    }
    private int bfs(char[][] maze, char target, int x, int y){
        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x,y,0});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int distance = curr[2];
            
            if(maze[currX][currY] == target){
                return distance;
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if(nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && !visited[nextX][nextY]
                  && maze[nextX][nextY] != 'X'){
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX,nextY,distance+1});
                }
                // target일 때도 움직여야하므로, O 말고 추가 조건을 준다.
            }
        }
        return -1;
    }
}