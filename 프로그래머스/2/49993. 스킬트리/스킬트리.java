import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        // 순서가 정해져있다 -> 큐?
        int cnt = 0;
        for(String str : skill_trees){
            if(checker(str,skill)){
                cnt++;
            }
        }
        return cnt;
    }
    private boolean checker(String str, String skill){
        ArrayDeque<String> queue = new ArrayDeque<>();
        for(String s : str.split("")){
            queue.offer(s);
        }
        int idx = 0;
        int n = queue.size();
        for(int i = 0; i < n; i++){
            String ele = queue.poll();
            if(skill.contains(ele)){
                if(skill.indexOf(ele) == idx){
                    idx++;
                    queue.offer(ele);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}