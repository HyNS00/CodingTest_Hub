import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        // 자주 바뀌는 값과 바뀌지 않는 값을 구분하는 자료형 -> map
        // 항상 일정하고 출력을 위해 map을 사용할 수도 있다.
        // result값을 기준으로 생각해서 코드를 작성하는 것도 가능하다.
        Map<String,String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");
        
        Map<String,String> id = new HashMap<>();
        for(String s : record){
            String[] tmp = s.split(" ");
            if(tmp.length == 3){
                 id.put(tmp[1],tmp[2]);   
            }
        }
        List<String> answer = new ArrayList<>();
        for(String s : record){
            String[] tmp = s.split(" ");
            if(msg.containsKey(tmp[0])){
                answer.add(id.get(tmp[1]) + msg.get(tmp[0]));
            }
        }
        return answer.toArray(new String[0]);
    }
}