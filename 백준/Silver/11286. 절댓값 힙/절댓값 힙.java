
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int x = Integer.parseInt(br.readLine());


        Comparator<Integer> comp = (a,b) -> {
            if(Math.abs(a) != Math.abs(b)) {
                return Integer.compare(Math.abs(a) , Math.abs(b));
            }else {
                return Integer.compare(a,b);
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < x; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp != 0) {
                pq.add(tmp);
            }else {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
