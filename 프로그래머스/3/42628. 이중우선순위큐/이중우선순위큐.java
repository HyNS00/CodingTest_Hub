import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] operations) {
      
    
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
       for(int i = 0; i < operations.length; i++){
           String[] s = operations[i].split(" ");
            if(s[0].equals("D") && maxQueue.isEmpty()) {
                continue;
            }
            if(s[0].equals("I")) {
                maxQueue.offer(Integer.parseInt(s[1]));
                minQueue.offer(Integer.parseInt(s[1]));
            }
            else if(s[0].equals("D") && s[1].equals("1")) {
                int max = maxQueue.poll();
                minQueue.remove(max);
            } else {
                int min = minQueue.poll();
                maxQueue.remove(min);
            }
       } 
       
        int[] answer = new int[2];
        answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.peek();
        answer[1] = minQueue.isEmpty() ? 0 : minQueue.peek();
        return answer;
    }
}