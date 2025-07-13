import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int start = 666;
        int cnt = 1;
        while(n > cnt){
            start++;
            if(String.valueOf(start).contains("666")){
                cnt++;
            }
        }
        bw.write(start+"\n");
        bw.close();
        br.close();
    }
}
