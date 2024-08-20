import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder().append(n);
        sb.reverse();
        return Arrays.stream(sb.toString().split("")).mapToInt(Integer::parseInt).toArray();
        
    }
}