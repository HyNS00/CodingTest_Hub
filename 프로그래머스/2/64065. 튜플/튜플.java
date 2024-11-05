import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String s) {
        String tmp = s.substring(2,s.length()-2);
        String[] arr = tmp.split("\\},\\{");
        Arrays.sort(arr,Comparator.comparingInt(String::length));
        
        Set<String> set = new LinkedHashSet<>();
        for(String str : arr){
            String[] kk = str.split(",");
            for(String a : kk){
                set.add(a);
            }
        }
        return set.stream().mapToInt(Integer::parseInt).toArray();
    }
}