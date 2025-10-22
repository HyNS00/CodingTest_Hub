
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[2][];
            for(int i  = 0; i < 2; i++){
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();

            }

            int[][] dp = new int[2][map[0].length];
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];
            if(map[0].length >= 2) {
                dp[0][1] = dp[1][0] + map[0][1];
                dp[1][1] = dp[0][0] + map[1][1];
                for(int i = 2; i < map[0].length; i++) {
                    dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];
                    dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];
                }
            }

            sb.append(Math.max(dp[0][dp[0].length-1], dp[1][dp[0].length-1])).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
