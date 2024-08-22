import java.util.stream.*;
class Solution {
    public int solution(int left, int right) {
        int k = IntStream.rangeClosed(left,right)
            .map(num ->{
                int n = (int)Math.sqrt(num);
                return n*n ==num ? -num : num;
            }).sum();
        return k;
    }
}