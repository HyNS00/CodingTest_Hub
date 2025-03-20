import java.util.*;
import java.util.stream.*;
class Solution {
    List<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        char[][] map = Arrays.stream(maps)
            .map(String::toCharArray).toArray(char[][]::new);
        
        int n = map.length;
        int m = map[0].length;
        
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != 'X' && !visited[i][j]){
                    dfs(map,i,j,visited);
                }
            }
        }
        if(list.isEmpty()){
            list.add(-1);
        }else{
            Collections.sort(list);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public void dfs(char[][] map, int x, int y, boolean[][] visited){
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int sum = 0;
        visited[x][y] = true;
        stack.push(new int[] {x,y});
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        while(!stack.isEmpty()){
            int[] curr = stack.pop();
            int currX = curr[0];
            int currY = curr[1];
            sum += Character.getNumericValue(map[currX][currY]);
            for(int i = 0; i < 4; i++){
                int nx = currX + dx[i];
                int ny = currY + dy[i];
                if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny]
                  && map[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    stack.push(new int[] {nx,ny});
                    
                } 
            }
        }
        if(sum > 0){
            list.add(sum);
        }
    }
}