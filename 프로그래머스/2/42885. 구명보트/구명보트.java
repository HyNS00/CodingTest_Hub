import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        // 가장 무거운 사람과 가장 가벼운 사람을 생각해보자.
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int boat = 0;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            }else{
                right--;
            }
            boat++;
        }
        return boat;
    }
}