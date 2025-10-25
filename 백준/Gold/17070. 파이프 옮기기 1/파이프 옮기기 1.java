

import java.io.*;
import java.util.Arrays;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(0,1,1,map);
        // 방향을 숫자로 편하게 나타낸다.
        // 표현을 익힌다.
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
    private static void dfs(int x, int y, int pose, int[][] map) {
        if(x == map.length -1 && y == map.length-1) {
            result++;
            return;
        }
        // 가로 ,대각선 -> 가로
        if((pose == 1 || pose == 2) && checker(x,y+1,map)){
            dfs(x, y + 1, 1, map);
        }
        // 세로,대각선 -> 세로
        if((pose == 2 || pose == 3) && checker(x+1,y,map)){
            dfs(x+1,y,3,map);
        }
        // 대각선은 모두가 가능
        if(checker(x+1,y,map) && checker(x,y+1,map) && checker(x+1,y+1,map)){
            dfs(x+1,y+1,2,map);
        }
    }
    private static boolean checker(int x, int y , int[][] map) {
        if( x >= 0 && x < map.length && y < map.length && y >= 0 && map[x][y] == 0) {
            return true;
        }
        return false;
    }



}
