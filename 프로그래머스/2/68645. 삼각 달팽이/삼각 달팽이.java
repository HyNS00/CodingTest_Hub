import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        int[][] chart = new int[n][n];
        int x = -1, y = 0;
        int num = 1;
        for(int i = n; i > 0; i-= 3){
            for(int j = 0; j < i; j++){
                chart[++x][y] = num++;
            }
            
            for(int j = 0; j < i-1; j++){
                chart[x][++y] = num++;
            }
            
            for(int j = 0; j < i-2; j++){
                chart[--x][--y] = num++;
            }
        }
        return Arrays.stream(chart).flatMapToInt(Arrays::stream).filter(e -> e!=0)
            .toArray();
    }
}