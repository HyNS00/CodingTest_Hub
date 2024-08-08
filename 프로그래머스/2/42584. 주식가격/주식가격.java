import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        stack.push(0);
        for(int i = 1; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int j = stack.pop();
                answer[j] = i - j; // 길이를 확정하는 단계
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = prices.length - 1 - j;
        }
        return answer;
    }
}