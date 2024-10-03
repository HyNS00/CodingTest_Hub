import java.util.*;
class Solution {
    private static HashMap<String,Integer> move = new HashMap<>();
    static{
        move.put("N",-1);
        move.put("S",1);
        move.put("W",-1);
        move.put("E",1);
    }
    public int[] solution(String[] park, String[] routes) {
        // 시작좌표 찾기
        int[] current = new int[2];
        int height = park.length;
        int wide = park[0].length();
        for(int i = 0; i < park.length; i++){
            String tmp = park[i];
            if(tmp.contains("S")){
                current[0] = i;
                current[1] = tmp.indexOf("S");
            }
        }
        
        for(String route : routes){
            int[] position = {current[0], current[1]};
            String[] tmp = route.split(" ");
            int distance = Integer.parseInt(tmp[1]);
            String direction = tmp[0];
            boolean isValid = true;
            for(int i = 0; i < distance; i++){
                if(direction.equals("N") || direction.equals("S")){
                    position[0] += (move.get(direction)) * 1;
                }else{
                    position[1] += (move.get(direction)) * 1;
                }
                if(position[0] < 0 || position[0] >= height || position[1] >= wide || position[1] <0 ||
                  park[position[0]].charAt(position[1]) == 'X'){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                current = position;
            }
        }
        return current;
    }
}