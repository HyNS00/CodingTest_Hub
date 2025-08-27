

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());

        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= target; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i-j*j],dp[i]);
            }
            dp[i] += 1;
        }

//        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        bw.write(String.valueOf(dp[target]));
        bw.close();
        br.close();
    }
}
