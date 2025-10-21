

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][];
        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();

        }
        // 누적합
        int[][] dp = new int[n][];
        for(int i= 0; i < n; i++){
            dp[i] = new int[i + 1];
        }
        dp[0][0] = map[0][0];
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j <= i; j++){
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + map[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + map[i + 1][j + 1]);
            }
        }
        int answer = Arrays.stream(dp[n-1]).max().getAsInt();
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
