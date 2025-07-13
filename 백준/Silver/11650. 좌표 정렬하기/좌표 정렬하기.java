
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] tmp = new int[2];

            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());

            list.add(tmp);
        }

        Comparator<int[]> comp = (a,b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else {
                return a[0] - b[0];
            }
        };

        list.sort(comp);
        StringBuilder sb = new StringBuilder();
        for(int[] tmp : list){
            sb.append(String.format("%d %d\n",tmp[0],tmp[1]));
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
