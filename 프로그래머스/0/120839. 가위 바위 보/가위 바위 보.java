import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        char[] tmp = rsp.toCharArray();
        String[] tmpString = IntStream.range(0, tmp.length)
            .mapToObj(i -> String.valueOf(tmp[i])).toArray(String[] :: new);
        // 가위 :2, 바위 0, 보 5 
        //      0,      5    2
        for(String a : tmpString){
            if(a.equals("2")){
                sb.append("0");
            }
            if(a.equals("0")){
               sb.append("5");
            }
            if(a.equals("5")){
                sb.append("2");
            }
        }
        return sb.toString();
    }
}