import java.util.*;
class Solution{
    public int solution(int [][]board){
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        int min = dp[i-1][j];
                        min = Math.min(min, dp[i][j-1]);
                        dp[i][j] = Math.min(min, dp[i-1][j-1])+1;
                    }
                }
            }
        }
        int maxSide = Arrays.stream(dp).flatMapToInt(r -> Arrays.stream(r))
            .max().getAsInt();
        return maxSide * maxSide;
    }
}