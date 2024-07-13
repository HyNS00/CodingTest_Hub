import java.util.*;
class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int max = sides[2];
        if(max >= sides[0] + sides[1]){
            return 2;
        }
        else{
            return 1;
        }
    }
}