import java.util.*;
class Solution{
    public int solution(String s)
    {
        // 짝지어있는지 확인한다
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            } else if(stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}