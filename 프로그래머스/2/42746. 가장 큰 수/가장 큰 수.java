import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        // String의 경우 사전순 정렬 이는 숫자도 포함된다.
        // comparable을 구현한 객체 String
        
        String answer = Arrays.stream(numbers).mapToObj(String::valueOf)
            .sorted((a,b) -> (b+a).compareTo(a+b)).collect(Collectors.joining());
        return answer.startsWith("0") ? "0" : answer;
    }
}