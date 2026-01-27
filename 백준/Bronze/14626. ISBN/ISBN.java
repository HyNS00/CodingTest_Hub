
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String tmp = br.readLine();
        int sum = 0;
        int place = -1;
        for(int i=0; i<13; i++) {
            char ch = tmp.charAt(i);
            if(ch == '*') {place = i; continue;}
            int temp = ch-'0';
            sum += i%2==0 ? temp : (temp*3);
        }

        int answer = -1;

        if(place%2==0) {
     
            for(int i=0; i<=9; i++) {
                if((sum+i)%10 == 0) {
                    answer = i; break;
                }
            }
        }
        else {
            for(int i=0; i<=9; i++) {
                if((sum+(i*3))%10 == 0) {
                    answer = i; break;
                }
            }
        }


        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
