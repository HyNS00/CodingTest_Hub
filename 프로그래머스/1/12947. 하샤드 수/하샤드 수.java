import java.util.*;
import java.util.stream.*;
class Solution {
    public boolean solution(int x) {
        String[] tmp = String.valueOf(x).split("");
        int sum = Arrays.stream(tmp).mapToInt(Integer::parseInt).sum();
        return x % sum == 0 ? true : false;
        
    }
}