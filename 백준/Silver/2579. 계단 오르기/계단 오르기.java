

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T+1];

        for(int i = 1; i <= T; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[T+1][3];

        dp[1][1] = arr[1];
        dp[1][2] = 0;
        if(T >= 2) {
            dp[2][1] = arr[2];
            dp[2][2] = arr[1]+arr[2];
        }

        for(int k = 3; k <= T; k++){
            dp[k][1] = Math.max(dp[k-2][1],dp[k-2][2]) + arr[k];
            dp[k][2] = dp[k-1][1] + arr[k];
        }

        int answer = Math.max(dp[T][1], dp[T][2]);
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
