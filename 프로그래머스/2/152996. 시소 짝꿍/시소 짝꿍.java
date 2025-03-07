import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double,Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        for(int w : weights){
            double t = (double) w;
            
            if(map.containsKey(t)){
                answer += map.get(t);
            }
            
            if(map.containsKey(t * (1.0/2))){
                answer += map.get(t* (1.0/2));
            }
            
//             if(map.containsKey(t * (1.0/3))){
//                 answer += map.get(t* (1.0/3));
//             }
            
//             if(map.containsKey(t * (1.0/4))){
//                 answer += map.get(t* (1.0/4));
//             }
            
            if(map.containsKey(t * (2.0/3))){
                answer += map.get(t* (2.0/3));
            }
            
            if(map.containsKey(t * (3.0/4))){
                answer += map.get(t* (3.0/4));
            }
            map.put(t, map.getOrDefault(t,0)+1);
        }
        return answer;
    }
}