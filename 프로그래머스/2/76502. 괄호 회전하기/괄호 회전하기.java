import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        // arraydeque를 stack처럼 사용하자
        // 왼쪽으로 회전은 substring을 사용하자
        for(int i = 0; i < s.length(); i++){
            Deque<Character> stack = new ArrayDeque<>();
            String tmp = s.substring(i) + s.substring(0,i);
            for(int j = 0; j < tmp.length(); j++){
                char c = tmp.charAt(j);
                if(stack.isEmpty()){
                    stack.push(c);
                }else if(c == ']' && stack.peek() == '['){
                    stack.pop();
                }else if(c == ')' && stack.peek() == '('){
                    stack.pop();
                }else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                } else{
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}