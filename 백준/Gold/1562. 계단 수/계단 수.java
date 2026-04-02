
import java.io.*;

public class Main {
    static int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[][][] dp = new long[n+1][10][1024];

        for(int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int mask = 0; mask < 1024; mask++){
                    if(dp[i][j][mask] == 0) continue;

                    if(j < 9) {
                        int next = mask | (1 << (j+1));
                        dp[i+1][j+1][next] = (dp[i+1][j+1][next] +dp[i][j][mask])% MOD;

                    }

                    if(j > 0) {
                        int next = mask | (1 << (j-1));
                        dp[i + 1][j - 1][next] = (dp[i+1][j-1][next]+dp[i][j][mask]) % MOD;
                    }
                }
            }
        }
        long total = 0;
        for(int i = 0; i <= 9; i++) {
            total = (total + dp[n][i][1023]) % MOD;
        }
        bw.write(String.valueOf(total));
        bw.close();
        br.close();
    }
}
