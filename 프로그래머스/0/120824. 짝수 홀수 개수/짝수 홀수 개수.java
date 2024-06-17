import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        // map으로 해서 +1 씩하고 마지막에 배열로 반환
        Map<String, Integer> map = new HashMap<>();
        map.put("even" ,0);
        map.put("odd",0);
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0){
                map.put("even",map.get("even")+1);
            }
            else{
                map.put("odd",map.get("odd")+1);
            }
        }
        int[] answer = new int[2];
        answer[0] = map.get("even");
        answer[1] = map.get("odd");
        return answer;
    }
}