import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
       // 배열을 뒤집는다.
        // 정렬을 할 필요 없다.
        Integer[] intToInteger = Arrays.stream(num_list).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(intToInteger);
        Collections.reverse(list);
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
}