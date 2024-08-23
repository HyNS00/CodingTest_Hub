import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,String> parent = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            parent.put(enroll[i], referral[i]);
        }
        Map<String, Integer> total = new HashMap<>();
        for(int i = 0; i < seller.length; i++){
            String current = seller[i];
            int price = amount[i] * 100;
            int commission = price / 10;
            total.put(current, total.getOrDefault(current, 0) + price - commission);
            while(!parent.get(current).equals("-") && commission > 0){
                current = parent.get(current);
                total.put(current, total.getOrDefault(current, 0) + commission - (commission/10));
                commission /= 10;
            }
        }
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = total.getOrDefault(enroll[i],0);
        }
        return answer;
    }
}