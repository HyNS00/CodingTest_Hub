import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> list = new ArrayList<>();
        int answer = 0;
        for(String city : cities){
            String tmp = city.toLowerCase();
            int idx = list.indexOf(tmp);
            if(idx >= 0){
                list.remove(idx);
                list.add(tmp);
                answer += 1;
            }else{
                list.add(tmp);
                answer+=5;
            }
            if(list.size() > cacheSize){
                list.remove(0);
            }
        }
        return answer;
    }
}