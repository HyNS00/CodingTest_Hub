import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int k) {
        String str = changer(n,k);
        int cnt = 0;
        for(String s : str.split("0")){
            if(!s.isEmpty() && checker(s)){
                cnt++;
            }
        }
        return cnt;
    }
    private boolean checker(String s){
        long num = Long.parseLong(s);
        if(num == 2 || num == 3){
            return true;
        }
        if(num % 2 == 0 || num == 1){
            return false;
        }
        for(int i = 3; i <= Math.sqrt(num); i+= 2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    private String changer(int n, int k){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        while(n != 0){
            int r = n % k;
            stack.push(r);
            n = n / k;
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}