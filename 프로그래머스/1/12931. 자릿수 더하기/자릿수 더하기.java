import java.util.*;
import java.util.stream.*;
public class Solution {
    public int solution(int n) {
        String[] tmp = String.valueOf(n).split("");
        return Arrays.stream(tmp).mapToInt(x -> Integer.parseInt(x)).sum();
    }
}