import java.util.*;
class Solution {
    public int solution(int[] number) {
        int cnt = 0;
        for(int i = 0; i < number.length -2; i++){
            for(int j = i+1; j < number.length -1; j++){
                for(int p = j+1; p < number.length; p++){
                    if(number[i]+number[j]+number[p] == 0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}