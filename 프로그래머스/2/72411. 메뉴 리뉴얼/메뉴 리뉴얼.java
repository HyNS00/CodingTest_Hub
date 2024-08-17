import java.util.*;
import java.util.stream.*;
class Solution {
    static Map<String,Integer> courseMap = new HashMap<>();
    static List<String> answer = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        for(int cnt : course){
            for(String order : orders){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                combination(0,arr,"",cnt);
            }
            int max = courseMap.values().stream().max(Integer::compare).orElse(0);
            courseMap.entrySet().stream().filter(entry -> entry.getValue() == max && max > 1)
                .forEach(entry -> answer.add(entry.getKey()));
            courseMap.clear();
            }
            return answer.stream().sorted().toArray(String[]::new);
        }
     static void combination(int idx, char[] arr, String result, int check){
        if(result.length() == check){
            courseMap.put(result, courseMap.getOrDefault(result, 0)+1);
            // 코스 요리 카운트
        }
        for(int i = idx; i < arr.length; i++){
            combination(i+1, arr, result + arr[i],check);
        }
    }
}