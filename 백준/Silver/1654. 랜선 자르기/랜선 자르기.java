
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        for(int i = 0; i < K; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long start = 1;
        long end = arr[K-1];
        long value = 0;
        while(start <= end){
            long mid = (start + end) / 2;

            long tmp = 0;
            for(long num : arr){
                tmp += num / mid;
            }
            if(tmp >= N) {
                value = Math.max(value,mid);
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        bw.write(String.valueOf(value));
        bw.close();
        br.close();
    }
}
