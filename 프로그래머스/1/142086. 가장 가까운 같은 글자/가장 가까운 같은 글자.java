import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<String,Integer> map = new HashMap<>();
        String[] tmp = s.split("");
        int[] answer = new int[tmp.length];
        answer[0] = -1;
        map.put(tmp[0], 0);
        for(int i = 1; i < tmp.length; i++){
            if(map.get(tmp[i]) == null){
                answer[i] =  -1;
            }else{
                //다른 값이 들어있다면
                answer[i] =  i - map.get(tmp[i]);
            }
            // 값이 안들어있었다는 증거
            map.put(tmp[i], i); // 0을 채워넣고
        }
        return answer;
    }
}