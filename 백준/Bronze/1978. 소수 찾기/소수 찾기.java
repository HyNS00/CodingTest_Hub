
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int cnt = 0;

        for(int i = 0; i < arr.length; i++){
            if(isPrime(arr[i])){
                cnt++;
            }
        }

        bw.write(cnt+ "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean isPrime(int n){
        if(n == 2){
            return true;
        }

        if(n % 2 == 0 || n == 1){
            return false;
        }

        for(int i = 3; i <= Math.sqrt(n); i+=2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
