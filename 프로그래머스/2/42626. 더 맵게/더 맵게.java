import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue= Arrays.stream(scoville).boxed()
            .collect(Collectors.toCollection(PriorityQueue::new));
        int cnt = 0;
        
        while(!checker(queue,K) && queue.size() >= 2){
            
            int fir = queue.poll();
            int sec = queue.poll();
            int newOne = fir + sec * 2;
            
            queue.offer(newOne);
            cnt++;
        }
        
        return !queue.isEmpty() && queue.peek() >= K ? cnt : -1;  
    }
    private boolean checker(PriorityQueue<Integer> queue,int k){
        return queue.peek() >= k ? true : false;
    }
}