import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int[] tmp = Arrays.stream(score).boxed().sorted(Comparator.reverseOrder())
            .mapToInt(x -> x).toArray();
        int n = tmp.length;
        int answer = 0;
        int idx = 0;
        // 0 1 2 3 4 5 6 
        // 길이는 12
        
        while(n >= m){
            answer += tmp[idx+m-1] * m;
            idx += m;
            n -= m;
        }
        return answer;
    }
}