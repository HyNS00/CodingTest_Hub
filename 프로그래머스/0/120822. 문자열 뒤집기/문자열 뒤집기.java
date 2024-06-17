import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] my_stringToChar = my_string.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char c : my_stringToChar){
            list.add(c);
        }
        Collections.reverse(list);
        StringBuilder answer = new StringBuilder();
        for(Character k : list){
            answer.append(k);
        }
        return answer.toString();
    }
}