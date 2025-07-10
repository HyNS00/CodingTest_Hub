
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int g = gcd(a,b);
        int r = (a*b) / g;

        bw.write(g + "\n" + r);
        bw.close();
        br.close();

    }

    public static int gcd(int x, int y){
        while(y > 0){
            int tmp = x;
            x = y;
            y = tmp % y;
        }
        return x;
    }
}
