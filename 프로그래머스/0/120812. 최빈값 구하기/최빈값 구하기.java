import java.util.HashMap;
class Solution {
    public int solution(int[] array) {
        // 해쉬맵으로 전부 담아 놓기
        HashMap<Integer,Integer> sample = new HashMap<>();
        for (int num : array){
            sample.put(num , sample.getOrDefault(num,0)+1);
        }
        
        // 최빈값 설정
        int mode = -1;
        int maxFrequency = 0;
        for(int key : sample.keySet()){
            int frequency = sample.get(key);
            if(frequency > maxFrequency){
                maxFrequency = frequency;
                mode = key;
            }else if(frequency == maxFrequency){
                mode = -1;
            }
        }
        return mode;
    }
}