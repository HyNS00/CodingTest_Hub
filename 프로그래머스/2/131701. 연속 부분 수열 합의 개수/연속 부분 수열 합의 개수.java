import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        for(int i = 0; i < n; i++){
            int element = elements[i];
            set.add(element);
            for(int j = i+1; j < n+i; j++){
                element += elements[j%n];
                set.add(element);
            }
        }
        return set.size();
    }
}