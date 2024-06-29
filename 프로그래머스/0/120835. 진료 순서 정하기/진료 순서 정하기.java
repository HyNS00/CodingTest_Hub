import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] result = new int[n];
        int[] sortedE = emergency.clone();
        Map<Integer, Integer> tmp = new HashMap<>();
        Arrays.sort(sortedE);
        for(int i = 0; i < n; i++){
            tmp.put(sortedE[i],  n - i);
        }
        for (int i = 0; i < n; i++){
            result[i] = tmp.get(emergency[i]);
        }
        return result;
    }
}