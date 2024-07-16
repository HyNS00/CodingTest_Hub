import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        List<String> answer = new ArrayList<>(); 
        // 먼저 quiz에 대해서 가져온다.
        for(String str : quiz){
            String[] tmp = str.split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[2]);
            int c = Integer.parseInt(tmp[4]);
            if(tmp[1].equals("+")){
                if(c == (b+a)){
                    answer.add("O");
                }else{ answer.add("X");}
            }else {
                if(c == (a-b)){
                    answer.add("O");
                }else{
                    answer.add("X");
                }
            }
        }
        String[] result = answer.toArray(new String[0]);
        return result;
    }
}