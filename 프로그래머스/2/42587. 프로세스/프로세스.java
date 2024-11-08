import java.util.*;
import java.util.stream.*;
class Solution {
    class Document{
        int priority;
        int index;
        
        Document(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
    public int solution(int[] priorities, int location) {
        int cnt = 0;
        ArrayDeque<Document>  deque = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            deque.add(new Document(priorities[i],i));
        }
        
        while(!deque.isEmpty()){
            Document current = deque.pollFirst();
            
            boolean check = deque.stream().anyMatch(x -> x.priority > current.priority);
            if(check){
                deque.addLast(current);
            }else{
                cnt++;
                if(current.index == location) {
                    return cnt;
                }
            }
            
        }
        return cnt;
    }
}