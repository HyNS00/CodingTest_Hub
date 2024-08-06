import java.util.*;
class Solution {
    boolean solution(String s) {
        int cnt = 0;
        char[] tmp = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : tmp){
            if(c == '('){
                stack.push(c);
            }else if(c == ')' && !stack.isEmpty()){
                stack.pop();
            }else{
                cnt++;
            }
        }
        return stack.isEmpty() && cnt == 0 ? true : false;
    }
}