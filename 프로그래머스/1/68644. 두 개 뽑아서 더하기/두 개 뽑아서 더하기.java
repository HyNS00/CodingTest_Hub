import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                int coin = numbers[i] +numbers[j];
                if(result.contains(coin)){
                    continue;
                }
                result.add(coin);
            }
        }
        Collections.sort(result);
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}