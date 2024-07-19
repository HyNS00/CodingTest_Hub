import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        //spell을 set으로 만들자
        Set<String> spellSet = new HashSet<>(Arrays.asList(spell));
        // dic을 set으로 만들자.
        // List<Set<String>> listDic = new ArrayList<>();
        for(String str : dic){
            Set<String> set = new HashSet<>(Arrays.asList(str.split("")));
            if(spellSet.equals(set)){
                answer--;
            }
        }
        return answer;
    }
}