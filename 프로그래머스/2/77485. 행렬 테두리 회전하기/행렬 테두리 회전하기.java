import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int value = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = value++;
            }
        }
        int idx = 0;
        for(int[] query : queries){
            answer[idx++] = adder(query, map);
        }
        return answer;
    }
    private int adder(int[] query, int[][] map){
       ArrayDeque<Integer> queue = new ArrayDeque<>();
        int sx = query[0]-1;
        int sy = query[1]-1;
        int ex = query[2]-1;
        int ey = query[3]-1;
        
        queue.add(map[sx+1][sy]);
        
        for(int i = sy; i <= ey; i++){
            queue.add(map[sx][i]);
        }
        
        for(int i = sx+1; i <= ex; i++){
            queue.add(map[i][ey]);
        }
        
        for(int i = ey-1; i >= sy; i--){
            queue.add(map[ex][i]);
        }
        
        for(int i = ex-1; i >= sx+2; i--){
            queue.add(map[i][sy]);
        }
        
        int answer = Collections.min(queue);
        
        for(int i = sy; i <= ey; i++){
            map[sx][i] = queue.poll();
        }
        
        for(int i = sx+1; i <= ex; i++){
            map[i][ey] = queue.poll();
        }
        
        for(int i = ey-1; i >= sy; i--){
            map[ex][i] = queue.poll();
        }
        
        for(int i = ex-1; i >= sx+1; i--){
            map[i][sy] = queue.poll();
        }
        
        return answer;
    }
    
}