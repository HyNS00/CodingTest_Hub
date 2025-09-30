import java.util.*;
class Solution {
    public int solution(int n) {
        int cnt = 1;
        for(int i = 3; i <= n; i++) {
            
            if(checker(i)) cnt++;
        }
        return cnt;
    }
    public boolean checker(int target) {
        if(target % 2 == 0) return false;
        
        for(int i = 3; i <= Math.sqrt(target); i+=2) {
            if(target % i == 0) return false;
        }
        return true;
    }
}