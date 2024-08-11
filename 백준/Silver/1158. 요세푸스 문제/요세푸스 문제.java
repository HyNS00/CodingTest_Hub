import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        sb.append("<");
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        int cnt = 0;
        while(queue.size() != 1){
            int value = queue.poll();
            cnt++;
            if(cnt % k == 0){
                sb.append(value).append(", ");
            }else{
                queue.add(value);
            }
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}