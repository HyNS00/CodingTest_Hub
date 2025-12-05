
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] ax = new long[n];
        long[] ay = new long[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            ax[i] = x;
            ay[i] = y;
        }
        long right = 0;
        long left = 0;
        for(int i = 0; i < n-1; i++) {
            right += ax[i]*ay[i+1];
            left += ay[i]*ax[i+1];
        }
        right += ax[n-1] * ay[0];
        left += ay[n-1] * ax[0];
        double result = Math.abs(right - left) / 2.0;
        bw.write(String.format("%.1f",result));
        bw.close();
        br.close();
    }
}
