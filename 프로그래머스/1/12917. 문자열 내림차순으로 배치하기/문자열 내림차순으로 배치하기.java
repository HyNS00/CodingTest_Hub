import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        //Character에는 대소문자 판단이 있다.
        // Character엔 Comparator.reverseOrder는 안되니까, Character.compare 활용
        char[] tmp = s.toCharArray();
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();
        for(int i = 0; i < tmp.length; i++){
            if(Character.isUpperCase(tmp[i])){
                upper.add(tmp[i]);
            } else{
                lower.add(tmp[i]);
            }
        }
        String front = lower.stream().sorted((a,b) -> Character.compare(b,a)).map(String::valueOf).collect(Collectors.joining());
        String back = upper.stream().sorted((a,b) -> Character.compare(b,a)).map(String::valueOf).collect(Collectors.joining());
        return front+back;
    }
}