import java.util.*;
import java.util.stream.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            String tmp = Long.toString(num, 2);
            
            if(tmp.indexOf("0") == -1){
                long upper = Long.parseLong(tmp+"1",2);
                answer[i] = (upper - num) / 2 + num;
                
            }else{
                int zero = tmp.lastIndexOf("0");
                if(zero == tmp.length() -1){
                    answer[i] = num + 1;
                }else{
                    answer[i] = finder(tmp,zero);   
                }
            }
        }
        
        return answer;
    }
    private long finder(String tmp,int zero){
        String[] arr = tmp.split("");
        arr[zero] = "1";
        arr[zero+1] = "0";
        String result = Arrays.stream(arr).collect(Collectors.joining());
        return Long.parseLong(result,2);
    }
}