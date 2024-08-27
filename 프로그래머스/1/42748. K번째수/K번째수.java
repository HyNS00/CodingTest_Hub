import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            // 1 5 2 6 3 7 4
            // 0 1 2 3 4 5 6
            int[] arr = commands[i];
            int[] sub = Arrays.copyOfRange(array,arr[0]-1,arr[1]); // 순서를 잘 기억하자
            Arrays.sort(sub);
            answer[i] = sub[arr[2]-1];
        }
        return answer;
    }
}