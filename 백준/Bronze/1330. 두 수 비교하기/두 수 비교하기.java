import java.io.*;
import java.util.*;
public class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        String answer = "";
        if(a > b) {
            answer = ">";
        }else if(a < b){
            answer = "<";
         }else {
            answer = "==";
        }
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}