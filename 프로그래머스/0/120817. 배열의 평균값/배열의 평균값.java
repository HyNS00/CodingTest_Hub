import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        // 스트림?
        return Arrays.stream(numbers).average().getAsDouble();
    }
}