import java.util.*;
class Solution {
    public String solution(String s) {
        List<String> one = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        String[] tmp = s.split("");
        for(String str : tmp){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                one.add(entry.getKey());
            }
        }
        Collections.sort(one);
        String answer = String.join("",one);
        return answer;
    }
}