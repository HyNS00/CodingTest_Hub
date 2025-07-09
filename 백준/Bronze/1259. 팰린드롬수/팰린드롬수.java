import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            bw.write(checker(input)+"\n");

        }
        bw.close();
        br.close();

    }
    public static String checker(String input){
        int start = 0;
        int end = input.length()-1;

        while(start <= end){
            if(input.charAt(start) != input.charAt(end)){
                return "no";
            }
            start++;
            end--;
        }
        return "yes";
    }
}
