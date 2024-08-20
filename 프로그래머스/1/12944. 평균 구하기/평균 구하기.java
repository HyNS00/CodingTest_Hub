import java.util.stream.*;
import java.util.*;
class Solution {
    public double solution(int[] arr) {
        double n = (double) arr.length;
        int sum = Arrays.stream(arr).sum();
        return sum / n;
    }
}