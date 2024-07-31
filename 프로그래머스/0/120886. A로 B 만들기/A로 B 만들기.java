import java.util.*;
class Solution {
    public int solution(String before, String after) {
        String[] beforeArr = before.split("");
        String[] afterArr = after.split("");
        Map<String,Integer> bMap = new HashMap<>();
        Map<String,Integer> aMap = new HashMap<>();
        for(int i = 0; i < beforeArr.length; i++){
            bMap.put(beforeArr[i], bMap.getOrDefault(beforeArr[i],0)+1);
            aMap.put(afterArr[i],aMap.getOrDefault(afterArr[i],0)+1);
        }
        if(bMap.equals(aMap)){
            return 1;
        }else{
            return 0;
        }
    }
}