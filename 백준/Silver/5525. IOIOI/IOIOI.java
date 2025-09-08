
import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         long n = Long.parseLong(br.readLine());
         long m = Long.parseLong(br.readLine());

        char[] s = br.readLine().toCharArray();

        long result = checker(s, n, m);
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
    private static long checker(char[] target, long n, long m) {
        long cnt = 0;
        long answer = 0;
        for(int i = 0; i < m; i++){
            if(i + 2 >= m) {
                break;
            }
            // 밀리는 조건 확인해보기
            if(target[i] == 'I' && target[i+1] == 'O' && target[i+2] == 'I'){
                cnt++;
                i++;

                if(cnt == n){
                    answer++;
                    cnt--;
                }
            }else {
                cnt = 0;
            }
        }
        return answer;
    }
}
