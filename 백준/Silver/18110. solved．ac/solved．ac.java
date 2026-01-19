import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n == 0) {
            bw.write("0");
            bw.close();
            br.close();
            return;
        }
        else {
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int standard = (int) Math.round(n * 0.15);
            Arrays.sort(arr);
            int sum = 0;
            for(int i = standard; i < n-standard; i++) {
                sum += arr[i];
            }
            int total = n - (2 * standard);
            int round = (int) Math.round((double) sum / total);
            bw.write(String.valueOf(round));
            bw.close();
            br.close();
        }
        
    }
}
