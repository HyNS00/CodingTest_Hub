import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        Arrays.sort(bill);
        int answer = 0;
        while(bill[0] > wallet[0] || bill[1] > wallet[1]){
            if(bill[0] > bill[1]){
                bill[0] = bill[0] / 2;
            }else{
                bill[1] = bill[1] / 2;
            }
            answer++;
            if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) break;
        }
        return answer;
    }
}