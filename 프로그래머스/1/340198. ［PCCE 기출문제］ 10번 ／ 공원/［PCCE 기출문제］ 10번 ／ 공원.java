import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int[] sorted = Arrays.stream(mats).boxed().sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue).toArray();
        int answer = 0;
        for(int mat: sorted){
            for(int i = 0; i < park.length; i++){
                for(int j = 0; j < park[0].length; j++){
                    if(park[i][j].equals("-1") && check(mat,i,j,park)){
                        return mat;
                    }
                }
            }
        }
        return -1;
    }
    private boolean check(int size, int x, int y, String[][] park){
        if(x + size > park.length || y + size > park[0].length){
            return false;
        }
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
}