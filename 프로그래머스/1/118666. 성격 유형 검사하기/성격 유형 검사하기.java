import java.util.*;
class Solution {
    private HashMap<Character,Integer> map = new HashMap<>();
    {
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
    }
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < survey.length; i++){
            int choice = choices[i];
            String tmp = survey[i];
            if(choice > 4){
                addScore(tmp.charAt(1), choice);
            }else{
                addScore(tmp.charAt(0),choice);
            }
        }
        // abcdefghijklmnopqrstuvwxyz
        // 삼항 연산자
        sb.append(map.get('R') >= map.get('T') ? "R":"T");
        sb.append(map.get('C') >= map.get('F') ? "C":"F");
        sb.append(map.get('J') >= map.get('M') ? "J":"M");
        sb.append(map.get('A') >= map.get('N') ? "A":"N");
        return sb.toString();
    }
    private void addScore(char c,int  choice){
        int score = Math.abs(choice -4);
        map.put(c, map.get(c)+score);
    }
}