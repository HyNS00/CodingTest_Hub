
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++){
            dp[i] = dp[i-1] + arr[i-1];
        }
        
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = checker(start, end, arr, dp);
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int checker(int start, int end, int[] arr,int[] dp){
        if(start == end){
            return arr[start-1];
        }
        
        return dp[end] - dp[start-1];
    }
}
