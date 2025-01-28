import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
       List<Integer> sorted = Arrays.stream(mats).boxed().sorted((a,b) -> Integer.compare(b,a))
            .collect(Collectors.toList());
        for(int mat : sorted){
            for(int i = 0; i < park.length; i++){
                for(int j = 0; j < park[0].length; j++){
                    if(park[i][j].equals("-1") && checker(mat,i,j,park)){
                        return mat;
                    }
                }
            }
        }
        return -1;
    }
    private boolean checker(int mat, int i, int j, String[][] park){
        if(i + mat > park.length || j + mat > park[0].length){
            return false;
        }
        for(int x = i; x < mat + i; x++){
            for(int y = j; y < mat + j; y++){
                if(!park[x][y].equals("-1")) return false;
            }
        }
        return true;
    }
}