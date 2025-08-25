
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 무조건 큰 수로 나눈다고 해서 작은 값으로 나눠지는게 아니다.
        // 전 조건에 따라 경우가 달라진다.
        // 3으로 나눠질 때, 2로 나눠질 때, 1로 나눠질 때

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + 1;

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }

            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }
        // System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        bw.write(String.valueOf(dp[n]));
        bw.close();
        br.close();
    }

}
