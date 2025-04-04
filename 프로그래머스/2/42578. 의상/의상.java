import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String[] clothe : clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1],0)+1);
        }
        int answer = 1;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            answer *= (entry.getValue()+1);
        }
        return answer-1;
    }
    
}