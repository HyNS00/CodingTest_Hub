import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int lastNumber = 1;
        if(n == 1) {
            bw.write(String.valueOf(1));
            bw.close();
            br.close();
            return;
        }
        int cnt = 1;
        while(true) {
            if(lastNumber >= n) {
                break;
            }
            lastNumber = lastNumber + (cnt * 6);
            cnt++;
            
        }
        bw.write(String.valueOf(cnt));
        
        bw.close();
        br.close();
        
    }
}
