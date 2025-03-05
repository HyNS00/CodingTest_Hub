import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String number, int k) {
        // 최대를 구해야하고 가장 조금만 반복
        // stack을 사용해보자. (전 원소와 현 원소를 비교할 때)
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cnt = 0;
        int[] arr = Arrays.stream(number.split(""))
            .mapToInt(Integer::parseInt).toArray();
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        if(min == max) {
            return Arrays.stream(arr).skip(k).mapToObj(String::valueOf)
                .collect(Collectors.joining());
        }
        for(int i = 0; i < arr.length; i++){
            int n = arr[i];
            while(!stack.isEmpty() && cnt < k && stack.peek() < n){
                stack.pop();
                cnt++;
            }
            stack.push(n);
        }
        while(stack.size() > arr.length - k){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        stack.stream().forEach(a -> sb.append(a));
        return sb.reverse().toString();
    }
}