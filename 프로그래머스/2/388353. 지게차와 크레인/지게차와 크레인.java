import java.util.*;
class Solution {
    // 둘러싼다 -> 위 아래로 +1 , 양옆에 +1
    // 한번에 없애야한다 -> 바로바로 없애면 안에 있는게 영향 받음
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public int solution(String[] storage, String[] requests) {
        int m = storage.length;
        int n = storage[0].length();
        
        char[][] map = new char[m+2][n+2];
        for(char[] chars : map) Arrays.fill(chars, '0');
        for(int i = 1; i <= m; i++) {
            char[] tmp = storage[i-1].toCharArray();
            for(int j = 1; j <= n; j++) {
                map[i][j] = tmp[j-1];
            }
        }
        
        for(String request : requests) {
            if(request.length() == 2) {
                remove(map, request.charAt(0));
            }else {
                remove(map, request);
            }
        }
        int cnt = 0;
        for(int i = 0; i < m+2; i++) {
            for(int j = 0; j < n+2; j++) {
                if(map[i][j] != '0') {
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
    private void remove(char[][] map, String str) {
        char target = str.charAt(0);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        queue.add(new int[] {0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(visited[nx][ny]) continue;
                
                if(map[nx][ny] == '0') {
                    queue.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
                if(map[nx][ny] == target) {
                    list.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        for(int[] next : list) {
            map[next[0]][next[1]] = '0';
        }
    }
    private void remove(char[][] map, char target) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == target) {
                    map[i][j] = '0';
                }
            }
        }
    }
}