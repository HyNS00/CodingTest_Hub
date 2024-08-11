import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        int n = progresses.length;
        int[] calDay = new int[n];
        for(int i = 0; i < n; i++){
            calDay[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        int first = calDay[0];
        for(int i = 0; i < n; i++){
            if(calDay[i] <= first){
                // 첫날보다 빨리 끝났다. -> 같이 배포
                cnt++;
            }else {
                // 첫날보다 많이 남았을시
                answer.add(cnt); // 현재 cnt를 넣는다.
                cnt = 1; // 초기화
                first = calDay[i];
            }
        }
        answer.add(cnt);
        return answer.stream().mapToInt(x -> x).toArray();
    }
}