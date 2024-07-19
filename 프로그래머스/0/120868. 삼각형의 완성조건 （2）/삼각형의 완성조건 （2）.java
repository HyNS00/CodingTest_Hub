import java.util.*;
class Solution {
    public int solution(int[] sides) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(sides);
        int b = sides[1];
        int a = sides[0];
        for(int i = 1; i < a+b; i++){
            if(a + i > b && b >= i){
                list.add(i);
            }
            else if(i >= b && a+b > i){
                list.add(i);
            }
        }
        return list.size();
        
    }
}