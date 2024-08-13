import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        /*
         11
         0 1 2 3 4 5 6 7 8 9
           1 2 3 4 5 6 7 8 9 10
        */
        int idx = 0;
        int check = 0;
        for(int i  = 0; i < discount.length-9; i++){
            Map<String,Integer> map_c = new HashMap<>(map);
            for(int j = i; j < i+10; j++){
                if(map_c.containsKey(discount[j])){
                    map_c.put(discount[j], map_c.get(discount[j])-1);
                }else{
                    break;
                }
            }
            if(map_c.values().stream().anyMatch(v -> v > 0)){
                continue;
            }
            cnt++;
        }
        
        return cnt;
    }
}