import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int total = 0;
        int cnt = 0;
        for(int money : d){
            if(total + money <= budget){
                total += money;
                cnt++;
            }else{
                break;
            }
        }
        return cnt;
    }
}