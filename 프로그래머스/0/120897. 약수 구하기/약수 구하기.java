import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        // 약수를 담는다.
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i*i <= n; i++){
            int tmp = 0;
            if(n % i == 0){
                tmp = n / i;
                list.add(tmp);
                list.add(i);
            }
        }
        Collections.sort(list);
        Set<Integer> set = new LinkedHashSet<>(list);
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}