import java.util.*;
class Solution {
    private static List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        
        move(n,1,3);
        return list.toArray(int[][]::new);
        
    }
    private void move(int n, int from, int to){
        if(n == 0){
            return;
        }
        move(n-1,from, 6-from-to);
        list.add(new int[]{from, to});
        
        move(n-1,6-from-to,to); 
        
    }
}