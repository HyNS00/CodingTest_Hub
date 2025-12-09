

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int mv = Integer.MAX_VALUE;
    static int[] zeroOne = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = n - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < mv) {
                mv = Math.abs(sum);
                zeroOne[0] = arr[left];
                zeroOne[1] = arr[right];
            }
            if(sum > 0) {
                right--;
            }else if(sum < 0) {
                left++;
            }else {
                break;
            }
        }
        bw.write(zeroOne[0] + " " + zeroOne[1]);
        bw.close();
        br.close();
    }
}
