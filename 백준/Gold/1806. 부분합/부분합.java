

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

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        // 연속된 수
        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        int sum = 0;
        // 투포인터
        while(true) {
            if(sum >= m) {
                min = Math.min(min, right - left);
                sum -= arr[left]; 
                left++;
            }else {
                if(right == n) break;
                sum += arr[right];
                right++;
            }
        }
        int result = min == Integer.MAX_VALUE ? 0 : min;
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
