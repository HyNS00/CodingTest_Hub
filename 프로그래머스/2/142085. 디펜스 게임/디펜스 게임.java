import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int cnt = 0;
        if(k >= enemy.length){
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int e : enemy){
            n -= e;
            pq.add(e);
            
            if(n < 0){
               if(k > 0){
                   if(!pq.isEmpty()){
                       n += pq.poll();
                       k--;
                   }
               }else{
                   return cnt;
               }
            }
            cnt++;
        }
        return cnt;
    }
}