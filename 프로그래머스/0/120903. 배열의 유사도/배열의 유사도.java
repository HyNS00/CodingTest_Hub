import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> set = new HashSet<>(Arrays.asList(s1));
        // ArrayList도 가능하지만, HashSet이 훨씬 빠르다.
        for(String str : s2){
            if(set.contains(str)){
                answer++;
            }
        }
        return answer;
    }
}