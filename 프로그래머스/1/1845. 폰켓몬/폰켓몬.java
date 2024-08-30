import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>(Arrays.stream(nums).boxed()
                                             .collect(Collectors.toList()));
        
        return set.size() > nums.length /2  ? nums.length / 2 : set.size();
    }
}