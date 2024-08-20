import java.util.*;
class Solution {
    public long solution(long n) {
        String[] tmp = String.valueOf(n).split("");
        String[] sorted = Arrays.stream(tmp).sorted(Comparator.reverseOrder())
            .toArray(String[]::new);
        String union = String.join("",sorted);
        return Long.valueOf(union);
    }
}