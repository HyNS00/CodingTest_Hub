
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[] arr = new long[101];
        arr[1] =1;
        arr[2] = 1;
        arr[3] =1;
        arr[4] = 2;
        arr[5] = 2;
        for(int i = 6; i <= 100; i++){
            arr[i] = arr[i-1] + arr[i-5];
        }

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
