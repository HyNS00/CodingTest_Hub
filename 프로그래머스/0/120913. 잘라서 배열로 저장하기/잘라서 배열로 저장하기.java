import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < my_str.length(); i+=n){
            if(n+i > my_str.length()){
                list.add(my_str.substring(i));
                break;
            }
            list.add(my_str.substring(i,n+i));
        }
        String[] answer = list.stream().toArray(String[]::new);
        return answer;
    }
}