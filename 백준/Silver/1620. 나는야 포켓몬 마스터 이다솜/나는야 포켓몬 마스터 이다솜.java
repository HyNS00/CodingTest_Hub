
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,String> map = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String tmp = br.readLine();
            map.put(tmp,String.valueOf(i));
            map.put(String.valueOf(i),tmp);

        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < M; j++){
            String aa = br.readLine();
            sb.append(map.get(aa)).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
