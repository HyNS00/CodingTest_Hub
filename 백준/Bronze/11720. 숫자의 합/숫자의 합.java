import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        String M = br.readLine();
        int answer = 0;
        for(String str : M.split("")){
            answer += Integer.parseInt(str);
        }
        bw.write(String.valueOf(answer)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}