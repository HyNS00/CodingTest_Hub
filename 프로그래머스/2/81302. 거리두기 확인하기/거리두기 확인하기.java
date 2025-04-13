import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        for(String[] room : places){
            if(checker(room)){
                answer[idx++] = 1;
            }else{
                answer[idx++] = 0;
            }
        }
        return answer;
    }
    private boolean checker(String[] room){
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            String tmp = room[i];
            for(int j = 0; j < 5; j++){
                if(tmp.charAt(j) == 'P'){
                    list.add(new int[] {i,j});
                }
            }
        }
        if(distance(list,room)){
            return true;
        }
        return false;
    }
    private boolean distance(List<int[]> list,String[] room){
        int n = list.size();
        for(int i = 0; i < n-1; i++){
            int[] p1 = list.get(i);
            for(int j = i+1; j < n; j++){
                int[] p2 = list.get(j);
                if(!mathatan(p1,p2,room)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean mathatan(int[] p1, int[] p2, String[] room){
        int ax = p1[0];
        int ay = p1[1];
        
        int bx = p2[0];
        int by = p2[1];
        
        int m = Math.abs(ax - bx) + Math.abs(ay-by);
        
        if(m <= 1) return false;
        if(m == 2){
            if(ax == bx || ay == by){
                int nx = (ax+bx) /2;
                int ny = (ay+by) /2;
                if(room[nx].charAt(ny) == 'X') return true;
            }else{
                if(room[ax].charAt(by) == 'X' && room[bx].charAt(ay) == 'X') return true;
            }
            return false;
        }
        return true;
    }
}