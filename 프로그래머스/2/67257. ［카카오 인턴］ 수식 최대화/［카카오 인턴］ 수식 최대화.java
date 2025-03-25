import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[][] operator = {
            {"+","-","*"},
            {"+", "*","-"},
            {"-","*","+"},
            {"-","+","*"},
            {"*","+","-"},
            {"*","-","+"}
        };
        
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                sb.append(c);
            }else{
                list.add(sb.toString());
                list.add(String.valueOf(c));
                sb.setLength(0);
            }
        }
        list.add(sb.toString());
        
        for(String[] s : operator){
            List<String> tmp = new ArrayList<>(list);
            for(String op : s){
                while(tmp.contains(op)){
                    for(int i = 0; i < tmp.size(); i++){
                        if(tmp.get(i).equals(op)){
                            long left = Long.parseLong(tmp.get(i-1));
                            long right = Long.parseLong(tmp.get(i+1));
                            long result = cal(left,right,tmp.get(i));
                            
                            tmp.set(i-1, String.valueOf(result));
                            tmp.remove(i);
                            tmp.remove(i); // 길이 조정
                            i--; // 인덱스 조정
                        }
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(tmp.get(0))));
        }
        return answer;
    }
    private long cal(long l, long r, String t){
        switch(t){
            case "*" :
                return l * r;
            case "-" :
                return l - r;
                
            case "+" :
                return l + r;
                
            default :
                return 0;
        }
    }
}