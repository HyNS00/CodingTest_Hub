import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challengers = new int[N+2]; // 인덱스로 접근
        for(int i = 0; i < stages.length; i++){
            challengers[stages[i]] += 1; // 값을 하나씩 추가
        }
        Map<Integer,Double> fails = new HashMap<>();
        double total = stages.length;
        for(int i = 1; i <= N; i++){
            // 인덱스 N+1은 이미 모두 통과했으니까 셀 필요가 없다.
            if(challengers[i] == 0){
                fails.put(i,0.0);
            }
            else{
                fails.put(i,challengers[i] / total);
                // 각 단계에서 줄어든만큼 total에서 제거
                total -= challengers[i];
            }
        }
        int[] answer = fails.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(),o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
        return answer;
    }
}