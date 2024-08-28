import java.util.*;
class Solution {
    public String solution(int[] food) {
        // [1,3,4,6]
        // [w,1,2,3] 
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            String tmp = String.valueOf(i);
            sb.append(tmp.repeat(food[i]/2));
        }
        answer.append(sb).append(0);
        answer.append(sb.reverse());
        return answer.toString();
    }
}