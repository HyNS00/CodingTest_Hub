import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> sample = new ArrayList<>();
        // 홀수인지 구분
        // 나머지 배열에 담기
        // for문을 이용해서
        if(n % 2 == 0){
            for(int i = 1; i < n; i+=2){
                sample.add(i);
            }
        }
        else{
            for(int i = 1; i < n+1; i+=2){
                sample.add(i);
            }
        }
        return sample.stream().mapToInt(Integer :: intValue).toArray();
    }
}