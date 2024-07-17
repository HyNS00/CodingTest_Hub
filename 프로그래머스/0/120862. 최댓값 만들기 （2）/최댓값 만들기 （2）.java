import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int n = numbers.length;
        Arrays.sort(numbers);
        int answer = Math.max(numbers[n-1]*numbers[n-2], numbers[0]*numbers[1]);
        return answer;
    }
}