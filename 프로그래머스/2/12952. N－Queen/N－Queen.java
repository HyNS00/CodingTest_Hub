class Solution {
    private int cnt = 0;
    public int solution(int n) {
        boolean[][] map = new boolean[n][n];
        setting(map,0,n);
        return cnt;
    }
    public void setting(boolean[][] map, int row,int n){
        if(row == n){
            cnt++;
            return;
        }
        for(int col = 0; col < n; col++){
            if(isPossible(row,col,n,map)){
                map[row][col] = true;
                setting(map,row+1,n);
                map[row][col] = false;
            }
        }
    }
    private boolean isPossible(int row, int col,int n,boolean[][] map){
        for(int i = 0; i < n; i++){
            if(map[i][col]) return false;
        }
        
        for(int i = row-1, j=col-1; i >= 0 && j >= 0; i--,j--){
            if(map[i][j]) return false;
        }
        
        for(int i = row-1,j=col+1; i >= 0 && j < n; i--,j++){
            if(map[i][j]) return false;
        }
        return true;
    }
}