import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> tmp = new ArrayDeque<>();
        tmp.offer(arr[0]);
        for(int i = 0; i < arr.length; i++){
            if(tmp.peekLast() == arr[i]){
                continue;
            }else{
                tmp.offerLast(arr[i]);
            }
        }
        return tmp.stream().mapToInt(x -> x).toArray();
    }
}