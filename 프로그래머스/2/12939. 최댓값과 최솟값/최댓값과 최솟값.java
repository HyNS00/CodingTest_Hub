import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tmp = s.split(" ");
        int[] arr = Arrays.stream(tmp).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        return answer +arr[0] +" " +arr[arr.length-1];
    }
}