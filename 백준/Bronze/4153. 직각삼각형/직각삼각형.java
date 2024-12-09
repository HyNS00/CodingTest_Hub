import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(tmp);

            int a = tmp[0];
            int b = tmp[1];
            int c = tmp[2];
            if(c == 0){
                break;
            }
            if(c*c == a*a + b*b){
                bw.write("right\n");
            }else{
                bw.write("wrong\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
