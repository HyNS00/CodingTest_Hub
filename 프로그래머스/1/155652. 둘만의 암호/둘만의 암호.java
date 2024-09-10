import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            for(int j = 0; j < index; j++){
                tmp++;
                if(tmp > 'z'){
                    tmp = 'a';
                }
                if(skip.contains(String.valueOf(tmp))) j--;
            }
            sb.append(tmp);
        }
        return sb.toString();
    }
}