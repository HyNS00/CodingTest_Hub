import java.util.*;
import java.util.stream.Stream.*;
class Solution {
    public int[] solution(String my_string) {
        String new_string = my_string.replaceAll("[^0-9]","");
        String[] str = new_string.split("");
        int[] result = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(result);
        return result;
    }
}