import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Set<String>> reported = new HashMap<>();
        Map<String,Integer> mail = new HashMap<>();
        // Set이 value값으로 들어가는걸 생각해보자
        for(String str : report){
            String[] tmp = str.split(" ");
            if(!reported.containsKey(tmp[1])){
                reported.put(tmp[1], new HashSet<>());
            }
            reported.get(tmp[1]).add(tmp[0]);
        }
        // entry를 잘 활용해야한다. 
        for(Map.Entry<String,Set<String>> entry : reported.entrySet()){
            int size = entry.getValue().size();
            if(size >= k){
                for(String member : entry.getValue()){
                    mail.put(member, mail.getOrDefault(member,0)+1);
                }
            }
        }
        for(int i = 0; i < id_list.length; i++){
            answer[i] = mail.getOrDefault(id_list[i],0);
        }
        return answer;
    }
}