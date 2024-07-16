import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] tmp = my_string.toLowerCase().toCharArray();
        Arrays.sort(tmp);
        String answer = new String(tmp);
        return answer;
        
        // 이런 방법
        /*
            String[] tmp = my_string.toLowerCase().split("");
            Arrays.sort(tmp);
            String answer = String.join("",tmp);
        */
    
    }
}