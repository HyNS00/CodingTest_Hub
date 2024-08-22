import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        int min = tmp[0];
        List<Integer> list = Arrays.stream(arr)
            .boxed()
            .filter(x -> x > min)
            .collect(Collectors.toList());
        if(list.size() == 0){
            return new int[] {-1};
        }else{
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}