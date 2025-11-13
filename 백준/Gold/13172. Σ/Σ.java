
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcdValue = gcd(a,b);
            int afterA = a / gcdValue;
            int afterB = b / gcdValue;

            long result = search(afterA, MOD-2);
            answer += ((afterB * result) % MOD) % MOD;

        }
        bw.write(String.valueOf(answer%MOD));
        bw.close();
        br.close();
    }
    private static int gcd(int a, int b) {
        while(b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    private static long search(long a, long b) {
        if(b == 0) return  1;
        if(b == 1) return a;
        long tmp = search(a, b/2);
        if(b % 2 == 1) {
            return tmp * tmp % MOD * a % MOD;
        }else {
            return tmp * tmp % MOD;
        }
    }
}
