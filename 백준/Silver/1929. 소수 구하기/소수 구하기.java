

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end  = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int j =  start; j <= end; j++){
            if(j % 2 == 0 && j != 2) continue;
            if(checker(j)) {
                sb.append(j).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static boolean checker(int target){
        if(target == 1) return false;
        if (target == 2) return true;
        if(target == 3) return true;
        for(int i  = 3; i <= Math.sqrt(target); i+= 2){
            if(target % i == 0 ){
                return false;
            }
        }
        return true;
    }
}
