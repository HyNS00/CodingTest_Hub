import java.util.*;
class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int box = 1;
        int cnt = 0;
        int idx = 0;
        while(idx < order.length){
            if(order[idx] > box){
                stack.push(box);
                box++;
            }else if(order[idx] == box){
                cnt++;
                idx++;
                box++;
            }else if(!stack.isEmpty() && stack.peek() == order[idx]){
                stack.pop();
                cnt++;
                idx++;
            }else{
                break;
            }
        }
        return cnt;
    }
}