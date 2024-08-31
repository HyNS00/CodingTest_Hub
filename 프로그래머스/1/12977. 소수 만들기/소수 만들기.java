import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(check(nums[i]+nums[j]+nums[k])){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    private boolean check(int num){
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i = 3; i * i <= num; i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}