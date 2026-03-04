
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long[] dp = new long[56];
        for(int i = 1; i <= 55; i++) {
            dp[i] = 2 * dp[i-1] + (1L << (i-1));
        }
        long answer = found(b,dp) - found(a-1,dp);

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
    private static long found(long n, long[] dp) {
        int length = Long.toBinaryString(n).length();
        long result = 0;
        long remaining = n;
        for(int i = length -1; i >= 0; i--) {
            long standard = 1L << i;
            if((remaining & standard) != 0) {
                result += dp[i];
                result += (remaining - standard +1);
                remaining -= standard;
            }

        }
        return result;
    }
}
