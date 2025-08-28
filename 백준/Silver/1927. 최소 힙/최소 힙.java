
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < t; i++){
            long tmp = Long.parseLong(br.readLine());

            if(tmp == 0){
                if(pq.isEmpty()) {
                    sb.append(0);
                }else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }else {
                pq.add(tmp);
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
