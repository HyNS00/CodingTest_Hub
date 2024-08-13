import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        // Map을 두 개 사용하는건 너무 비효율적
        Map<String,Integer> pMap = new HashMap<>();
        for(String p : participant){
            pMap.put(p, pMap.getOrDefault(p, 0)+1);
        }
        for(int i = 0; i < completion.length; i++){
            pMap.put(completion[i], pMap.get(completion[i]) -1);
        }
        for(String a : participant){
            if(pMap.get(a) != 0){
                return a;
            }
        }
        return "";
    }
}