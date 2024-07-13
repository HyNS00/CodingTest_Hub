import java.util.*;
class Solution {
    public String solution(String my_string) {
        String[] tmp = my_string.split("");
        Set<String> set = new LinkedHashSet<>(Arrays.asList(tmp));
        // LinkedHashSet은 순서를 보장해준다.
        
        StringBuilder sb = new StringBuilder();
        // 문자열을 출력값으로 사용할 때 StringBuilder를 사용해보자
        for(String str : set){
            sb.append(str);
        }
        return sb.toString();
    }
    
}