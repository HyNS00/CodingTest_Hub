import java.util.*;
class Solution {
    public int[] solution(int money) {
        // 아아 5500
        int[] answer = new int[2];
        int coffee = money / 5500;
        int result = money % 5500;
        answer[0] = coffee;
        answer[1] = result;
        return answer;
    }
}