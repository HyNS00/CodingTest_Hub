
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 누적합 구하는거 학습해보기
        // 옆 + 위 - 겹치는거
        for(int i = 1; i <= n; i++) {
            for(int j =1; j <= n; j++) {
                dp[i][j] = map[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < m; t++) {
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int result = checker(target,dp);
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int checker(int[] target,int[][] dp) {
        int x1 = target[0];
        int y1 = target[1];
        int x2 = target[2];
        int y2 = target[3];

        return dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];

    }
}
