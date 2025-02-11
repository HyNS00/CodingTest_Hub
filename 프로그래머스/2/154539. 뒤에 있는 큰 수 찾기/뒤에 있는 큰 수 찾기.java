import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        answer[n-1] = -1;
        stack.push(n-1);
        
        for(int i = n-2; i >= 0; i--){
            while(!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]){
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : numbers[stack.peek()];
            stack.push(i);
        }
        return answer;
    }
}