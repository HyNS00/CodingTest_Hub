import java.util.*;
public class Solution {
    public int solution(int n) {
        int cnt = 0;
        if(n == 0) return 0;
        if(n == 1) return 1;
        while(n > 0){
            if(n % 2 != 0){
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }
}