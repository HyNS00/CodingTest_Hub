import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String,HashMap<String,Integer>> map = new HashMap<>();
        HashMap<String,Integer> giftMap = new HashMap<>();
        int[] answers = new int[friends.length];
        for(int i = 0; i < friends.length; i++){
            map.put(friends[i], new HashMap<>());
            giftMap.put(friends[i],0);
        }
        for(String gift : gifts){
            String[] tmp = gift.split(" ");
            String giver = tmp[0];
            String receiver = tmp[1];
            
            HashMap<String,Integer> record = map.get(giver);
            record.put(receiver, record.getOrDefault(receiver,0)+1);
            giftMap.put(giver, giftMap.get(giver)+1);
            giftMap.put(receiver, giftMap.get(receiver) -1);
        }
        for(int i = 0; i < friends.length-1; i++){
            for(int j = i+1; j < friends.length; j++){
                String me = friends[i];
                String you = friends[j];
                int iGive = map.get(me).getOrDefault(you,0);
                int uGive = map.get(you).getOrDefault(me,0);
                if(iGive > uGive){
                    answers[i]++;
                }else if(uGive > iGive){
                    answers[j]++;
                }else{
                    int myValue = giftMap.get(me);
                    int yourValue = giftMap.get(you);
                    if(myValue > yourValue){
                        answers[i]++;
                    }
                    if(yourValue > myValue){
                        answers[j]++;
                    }
                }
            }
        }
        int maxGift = Arrays.stream(answers).max().orElse(0);
        // count는 long을 반환
        return maxGift;
    }
}