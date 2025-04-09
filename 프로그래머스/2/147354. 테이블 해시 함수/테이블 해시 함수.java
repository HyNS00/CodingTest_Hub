import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
       Comparator<int[]> comp = Comparator.comparingInt((int[]d) -> d[col-1])
           .thenComparing((int[]d) -> d[0], Comparator.reverseOrder());
        
        Arrays.sort(data,comp);
        int idx = 1;
        int sum = 0;
        for(int[] row : data){
            if(idx >= row_begin && idx <= row_end){
                int result = cal(row, idx);
                sum ^= result;
            }
            idx++;
            if(idx > row_end){
                break;
            }
        }
        return sum;
    }
    private int cal(int[] row, int idx){
        int total = 0; 
        for(int r : row){
            total += r % idx;
        }
        return total;
    }
    
}