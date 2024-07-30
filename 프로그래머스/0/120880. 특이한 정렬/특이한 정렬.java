import java.util.stream.Stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        // n을 기준으로 n과가까운 수부터 정렬
        // 가까운 수 대로 정렬을 하는데, 큰 값이 있으면 그게 더 앞순위
        Integer[] nums = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a,b)->{
            int distA = Math.abs(a - n);
            int distB = Math.abs(b - n);
            if (distA == distB) {
                return b.compareTo(a);
            }
            return Integer.compare(distA, distB);
        });
        return Arrays.stream(nums).mapToInt(x -> x).toArray();
    }
}