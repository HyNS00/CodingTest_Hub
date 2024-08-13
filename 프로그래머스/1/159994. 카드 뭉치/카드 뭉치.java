import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // for문도 좋은데, while을 생각해보자.
        // 한번에 따로따로도 좋지만 같이 움직이는걸 생각해보자.
        Deque<String> first = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> second = new ArrayDeque<>(Arrays.asList(cards2));
        Deque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));
        
        while(!goalDeque.isEmpty()){
            if(!first.isEmpty() && first.peekFirst().equals(goalDeque.peekFirst())){
                first.pollFirst();
                goalDeque.pollFirst();
            }else if(!second.isEmpty() && second.peekFirst().equals(goalDeque.peekFirst())){
                second.pollFirst();
                goalDeque.pollFirst();
            }else{
                break;
            }
        }
        return goalDeque.isEmpty() ? "Yes" : "No";
        
    }
}