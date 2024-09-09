import java.util.*;
class Solution {
    public int solution(String dartResult) {
        ArrayList<Integer> list = new ArrayList<>();
        int current = 0;
        int sum = 0;
        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(Character.isDigit(c)){
                if(c == '1' && i+1 < dartResult.length() && dartResult.charAt(i+1) == '0'){
                    current = 10;
                    i++;
                }else{
                    current = c - '0';
                }
            }else{
                switch(c){
                    case 'T' :
                        list.add((int) Math.pow(current, 3));
                        break;
                    case 'S' :
                        list.add(current);
                        break;
                    case 'D' :
                        list.add((int) Math.pow(current, 2));
                        break;
                    case '#' :
                        if(!list.isEmpty()){
                            int last = list.size() - 1;
                            list.set(last, list.get(last) * -1);
                        }
                        break;
                    case '*':
                        if(!list.isEmpty()){
                            int last = list.size() - 1;
                            list.set(last, list.get(last) * 2);
                            if(list.size() > 1){ 
                                list.set(last - 1, list.get(last - 1) * 2);
                            }
                        }
                        break;
                }
            }
        }
        for(int a : list){
            sum += a;
        }
        return sum;
    }
}
