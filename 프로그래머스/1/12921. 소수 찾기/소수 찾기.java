import java.util.*;
class Solution {
    private static List<Integer> list = new ArrayList<>();
    public int solution(int n) {
        for(int i = 1; i <= n; i++){
            check(i);
        }
        return list.size();
    }
    private void check(int n){
        if(n < 2) return;
        if(n == 2) {
            list.add(2);
            return;
        }
        if(n % 2 == 0) return;
        boolean flag = true;
        for(int i = 3; i * i <= n; i+=2){
            if(n % i == 0){
                flag = false;
                break;
            }
        }
        if(flag){
            list.add(n);
        }
    }
    
}