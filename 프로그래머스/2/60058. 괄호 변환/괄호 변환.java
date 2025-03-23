import java.util.*;
class Solution {
    public String solution(String p) {
       return recur(p); 
    }
    public String recur(String s){
        if(s.isEmpty()){
            return "";
        }
        int idx = spliter(s);
        String u = s.substring(0,idx +1);
        String v = s.substring(idx+1);
        
        if(checker(u)){
            return u + recur(v);
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(recur(v)); // v에대해서 1단계부터 재귀적으로 한다.
            sb.append(")");
            String sw = flip(u.substring(1,u.length()-1));
            sb.append(sw);
            return sb.toString();
        }
    }
    private int spliter(String s){
        int cnt = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            }else{
                cnt--;
            }
            
            if(cnt == 0){
                result = i;
                break;
            }
        }
        return result;
    }
    private boolean checker(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
                
            }
        }
        return stack.isEmpty();
    }
    private String flip(String s){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                sb.append(")");
            }else{
                sb.append("(");
            }
        }
        return sb.toString();
    }
}