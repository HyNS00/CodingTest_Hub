import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        long[] b = new long[n];
        long[] c = new long[n];
        long[] d = new long[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        long[] ab = new long[n * n];
        long[] cd = new long[n * n];

        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ab[idx] = a[i] + b[j];
                cd[idx] = c[i] + d[j];
                idx++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        int left = 0;
        int right = idx-1;

        long cnt = 0;
        while(left <= idx-1 && right >= 0) {
            long target = ab[left] + cd[right];
            if(target > 0) {
                right--;
            } else if(target < 0) {
                left++;
            } else {
                long leftCnt = 0;
                long currLeft = ab[left];
                while(left <= idx-1 && currLeft == ab[left]) {
                    leftCnt++;
                    left++;
                }

                long rightCnt = 0;
                long currRight = cd[right];
                while (right >= 0 && currRight == cd[right]) {
                    rightCnt++;
                    right--;
                }
                cnt += leftCnt * rightCnt;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
}
