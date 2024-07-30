import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        double[] avgers = new double[n];
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            avgers[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        // 반복문을 돌면서 rank를 계속해서 초기화
        for(int i = 0; i < n; i++){
            int rank = 1;
            for(int j = 0; j < n; j++){
                if(avgers[j] > avgers[i]){
                    rank++;
                }
            }
            answer[i] = rank;
        }
        return answer;
    }
}