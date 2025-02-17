import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for(String record : records){
            String[] car = record.split(" ");
            int carNum = Integer.parseInt(car[1]);
            if(!map.containsKey(carNum)){
                map.put(carNum,new ArrayList<>());
            }
            map.get(carNum).add(changer(car[0]));
        }
        int[] answer = new int[map.size()];
        int idx = 0;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() % 2 != 0){
                entry.getValue().add(1439);
            }
            answer[idx++] = calculate(entry.getValue(), fees);
        }
        return answer;
        
    }
    private int changer(String str){
        String[] time = str.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    private int calculate(List<Integer> list, int[] fee){
        int sum = 0;
        for(int i = 0; i < list.size()-1; i+=2){
            sum += list.get(i+1) - list.get(i);
        }
        if(sum <= fee[0]){
            return fee[1];
        }else{
            int tmp = sum - fee[0];
            return fee[1] + (int) Math.ceil((double) tmp / fee[2]) * fee[3];
        }
    }
}