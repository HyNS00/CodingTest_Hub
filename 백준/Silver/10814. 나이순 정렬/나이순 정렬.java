

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

        List<String[]> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] tmp = new String[3];

            StringTokenizer st = new StringTokenizer(br.readLine());
            tmp[0] = st.nextToken();
            tmp[1] = st.nextToken();
            tmp[2] = String.valueOf(i);
            list.add(tmp);
        }

        Comparator<String[]> comp = (a,b) ->{
            if(Integer.parseInt(a[0]) == Integer.parseInt(b[0])){
                return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
            }

            return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
        };

        list.sort(comp);

        StringBuilder sb = new StringBuilder();

        for(String[] tmp : list){
            sb.append(String.format("%s %s\n",tmp[0],tmp[1]));
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
