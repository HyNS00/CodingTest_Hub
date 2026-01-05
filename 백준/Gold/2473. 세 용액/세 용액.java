

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        // 정렬하고
        Arrays.sort(arr);
        long minAbs = Long.MAX_VALUE;
        long[] result = new long[3];
        boolean flag = false;
        for(int i = 0; i < n-2; i++) {
            int left = i+1;
            int right = n-1;
            while(left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                if(Math.abs(sum) < minAbs) {
                    minAbs = Math.min(Math.abs(sum), minAbs);
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }
                if(sum > 0) {
                    right--;
                }else if(sum < 0) {
                    left++;
                }else {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            sb.append(result[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
