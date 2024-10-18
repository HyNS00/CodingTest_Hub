import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer =new int[2];
        ArrayList<String> list =new ArrayList<>();
        int round = 1;
        list.add(words[0]);
        for(int i = 1; i< words.length; i++){
            String curr = words[i];
            String pre = words[i-1];
            if(list.contains(curr) || curr.charAt(0) != pre.charAt(pre.length()-1)){
                answer[0] = i%n+1;
                answer[1] = round;
                break;
            }
            list.add(curr);
            
            if(list.size() % n == 0){
                round++;
            }
        }
        return answer;
    }
}