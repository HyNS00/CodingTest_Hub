

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n;
    static int minValue = Integer.MAX_VALUE;
    static int INF =1000 * 1000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[][] colors = new int[n][3];


        for(int i = 0; i < n; i++) {
            colors[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 1과 n은 달라야함
        // 근데 양옆에 붙어있는거 달라야함

        for(int i = 0; i < 3; i++) {
            int result = checker(i, colors);
            minValue = Math.min(result, minValue);
        }
        bw.write(String.valueOf(minValue));

        bw.close();
        br.close();
    }
    private static int checker(int start, int[][] colors) {
        int[][] dp = new int[n][3];

        Arrays.fill(dp[0],INF);
        dp[0][start] = colors[0][start];

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + colors[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + colors[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + colors[i][2];
        }

        if(start == 0) {
            return Math.min(dp[n - 1][1], dp[n - 1][2]);
        }else if(start == 1) {
            return Math.min(dp[n - 1][2], dp[n - 1][0]);
        }else {
            return Math.min(dp[n - 1][0], dp[n - 1][1]);
        }
    }
}
