import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int n = array.length;
        int[] tmp = Arrays.copyOf(array, n);
        Arrays.sort(array);
        int max = array[n-1];
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(tmp[i] == max){
                idx = i;
            }
        }
        answer[0] = max;
        answer[1] = idx;
        return answer;
        
        
    }
}