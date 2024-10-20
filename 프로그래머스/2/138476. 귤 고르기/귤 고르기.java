import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        for(int orange : list){
            k -= orange;
            count++;
            if(k <= 0){
                break;
            }
        }
        return count;
    }
}