import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer= new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for(String key : keymap){
            for(int i = 0; i < key.length(); i++){
                char c = key.charAt(i);
                map.put(c, Math.min(i+1, map.getOrDefault(c, Integer.MAX_VALUE)));
            }
        }
        for(int i = 0; i < targets.length; i++){
            for(int j = 0; j < targets[i].length(); j++){
                char c = targets[i].charAt(j);
                if(map.containsKey(c)){
                    answer[i] += map.get(c);
                }else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}