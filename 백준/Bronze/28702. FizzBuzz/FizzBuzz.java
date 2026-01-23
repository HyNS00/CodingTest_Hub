
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num1 = br.readLine();
        String num2 = br.readLine();
        String num3 = br.readLine();
        
        int num = 0;
        
       
        if(isNumber(num1)) {
            num = Integer.parseInt(num1) + 3;
        } else if(isNumber(num2)) {
            num = Integer.parseInt(num2) + 2;
        } else {
            num = Integer.parseInt(num3) + 1;
        }

        
        if(num % 3 == 0 && num % 5 == 0) {
            bw.write("FizzBuzz");
        } else if(num % 3 == 0) {
            bw.write("Fizz");
        } else if(num % 5 == 0) {
            bw.write("Buzz");
        } else {
            
            bw.write(String.valueOf(num)); 
        }


        bw.flush(); 
        bw.close();
        br.close();
    }

    static boolean isNumber(String number) {
        return !number.equals("FizzBuzz") && !number.equals("Fizz") && !number.equals("Buzz");
    }
}