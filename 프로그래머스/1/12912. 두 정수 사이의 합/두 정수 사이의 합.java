import java.util.*;
import java.util.stream.*;
class Solution {
    public long solution(int a, int b) {
        if(a == b){
            return a;
        }else{
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            long answer = LongStream.rangeClosed(min,max).sum();
            return answer;
        }
    }
}