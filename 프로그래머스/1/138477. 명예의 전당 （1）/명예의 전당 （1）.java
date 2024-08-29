import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> glory = new ArrayList<>();
        int[] answer = new int[score.length];
        for(int i = 0; i < score.length; i++){
            glory.add(score[i]);
            Collections.sort(glory,Comparator.reverseOrder());
            if(glory.size() < k){
                answer[i] = glory.get(i);
            }else{
                answer[i] = glory.get(k-1);
            }
        }
        return answer;
    }
}