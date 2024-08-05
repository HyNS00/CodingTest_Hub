import java.util.*;
class Solution {
    private static boolean isValid(int nx, int ny){
        return nx < 11 && ny < 11 && nx >= 0 && ny >= 0;
    }
    private static final Map<Character,int[]> location = new HashMap<>();
    
    public int solution(String dirs) {
        Set<String> answer = new HashSet<>();
        initStart();
        int x = 5, y = 5;
        for(int i = 0; i < dirs.length(); i++){
            int[] direction = location.get(dirs.charAt(i));
            int nx = x + direction[0];
            int ny = y + direction[1];
            if(!isValid(nx,ny)){
                continue;
            }
            answer.add(x + " " + y + " " + nx + " " + ny); // (x,y) -> (nx,ny)를 의미
            answer.add(nx + " " + ny + " " + x + " " + y); // (nx,ny) -> (x,y)를 의미
            // 방향성을 따지지 않고 경로의 여부를 물음
            x = nx;
            y = ny; // 좌표 업데이트
        }
        return answer.size() / 2; // 한번 이동에 2개의 좌표를 입력했으니 나누기 2
    }
    private static void initStart(){
        location.put('U',new int[]{0,1});
        location.put('D',new int[]{0,-1});
        location.put('L',new int[]{-1,0});
        location.put('R',new int[]{1,0});
    }
}