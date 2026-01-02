import java.io.*;
import java.util.Arrays;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = arr.length;
        int[][][] dp = new int[n][5][5];
        // 5인 이유는 left 가 5, right 가 5
        for(int[][] tmp : dp) {
            for(int[] row : tmp) {
                Arrays.fill(row,INF);
            }
        }
        dp[0][0][0] = 0;
        for(int i = 0; i < n-1; i++) {
            int position = arr[i];
            for(int left = 0; left < 5; left++) {
                for(int right = 0; right < 5; right++) {
                    if(dp[i][left][right] == INF) continue;
                    if(left != position) {
                        dp[i + 1][left][position] = Math.min(dp[i + 1][left][position], dp[i][left][right] + move(right, position));
                        // 오른발로 position을 밟았을 때 경우
                    }
                    if(right != position) {
                        dp[i + 1][position][right] = Math.min(dp[i + 1][position][right], dp[i][left][right] + move(left, position));
                    }

                }
            }
        }
        int min = INF;
        for(int left = 0; left < 5; left++) {
            for(int right = 0; right < 5; right++) {
                min = Math.min(min, dp[n - 1][left][right]);
            }
        }
        bw.write(String.valueOf(min));

        bw.close();
        br.close();
    }
    private static int move(int curr, int position) {
        if(curr == 0) return 2;
        if(curr == position) return 1;
        if(Math.abs(curr - position) == 2) return 4;
        return 3;
    }

}
