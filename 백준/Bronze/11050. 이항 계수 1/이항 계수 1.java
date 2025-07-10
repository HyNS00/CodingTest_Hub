

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=  new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        bw.write(checker(a,b)+ "\n");
        bw.close();
        br.close();
    }
    public static int checker(int a,int b){
        int answer = 0;
        if(b == 0){
            return 1;
        }else if(b==1){
            return a;
        } else if (a == b) {
            return 1;
        } else {
            int remain = a - b;
            answer = factorial(a) / (factorial(b) * factorial(a-b));

        }
        return answer;
    }
    private static int factorial(int x){
        if(x == 1 || x == 0){
            return x;
        }
        return factorial(x-1) * x;
    }
}
