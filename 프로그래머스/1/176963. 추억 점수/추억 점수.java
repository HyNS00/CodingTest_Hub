import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> score = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            score.put(name[i],yearning[i]);
        }
        ArrayList<Integer> answer =new ArrayList<>();
        for(String[] str : photo){
            int sum = 0;
            for(int i = 0; i < str.length; i++){
                if(score.containsKey(str[i])){
                    sum += score.get(str[i]);
                }else{
                    continue;
                }
            }
            answer.add(sum);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}