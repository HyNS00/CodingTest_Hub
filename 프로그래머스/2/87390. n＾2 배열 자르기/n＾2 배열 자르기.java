import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int idx = 0;
        int[] answer = new int[(int)(right- left+1)];
        for(long i = left; i <= right; i++){
            answer[idx++] = (int) Math.max(i/n, i%n) +1;
        }
        return answer;
    }
}