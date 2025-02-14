import java.util.*;
class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        // 메모리 때문에 계속 바꾸면 안됨 -> 한번만 계산 -> 새로운 배열-> 한번만 계산 -> 새로운 배열
        for(int row = 1; row < n; row++){
            for(int curr = 0; curr < 4; curr++){
                int tmp = 0;
                for(int j = 0; j < 4; j++){
                    if(curr != j){
                        tmp = Math.max(tmp,dp[row-1][j]);
                    }
                }
                dp[row][curr] = tmp + land[row][curr];
            }
        }
        return Arrays.stream(dp[n-1]).max().getAsInt();
    }
}