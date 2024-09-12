import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String X, String Y) {
        HashMap<Integer,Integer> xMap = new HashMap<>();
        HashMap<Integer,Integer> yMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i< X.length(); i++){
            int num = X.charAt(i) -'0';
            xMap.put(num, xMap.getOrDefault(num, 0)+1);
        }
        for(int i = 0; i < Y.length(); i++){
            int num = Y.charAt(i) -'0';
            yMap.put(num,yMap.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : xMap.entrySet()){
            if(yMap.containsKey(entry.getKey())){
                int tmp = Math.min(yMap.get(entry.getKey()), entry.getValue());
                for(int i = 0; i < tmp; i++){
                    list.add(entry.getKey());
                }
            }
        }
        if(list.isEmpty()){
           return "-1";
        }else{
            boolean allZero = list.stream().allMatch(n -> n == 0);
            if(allZero){
                return "0";
            }else{
                return list.stream().sorted(Comparator.reverseOrder()).map(String::valueOf)
                    .collect(Collectors.joining());
            }
        }
    }
}