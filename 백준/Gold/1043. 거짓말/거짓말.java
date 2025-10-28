
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        if(cnt == 0) {
            bw.write(String.valueOf(M));
            bw.close();
            br.close();
            return;
        }

        int[] knowPeople = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            knowPeople[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] knowTrue = new boolean[N + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int kp : knowPeople) {
            knowTrue[kp] = true;
            queue.add(kp);
        }

        List<List<Integer>> party = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            party.add(new ArrayList<>());
        }


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for(int j  = 0; j < count; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.get(i).add(person);

            }
        }

        while(!queue.isEmpty()) {
            int participant = queue.poll();

            for(int i = 0; i < M; i++) {
                if (party.get(i).contains(participant)) {
                    for(int other : party.get(i)) {
                        if(!knowTrue[other]) {
                            knowTrue[other] = true;
                            queue.add(other);
                        }
                    }
                }
            }
        }
        int result = 0;
        for(int i = 0; i < M; i++) {
            boolean canLie = true;
            List<Integer> list = party.get(i);
            for(int num : list) {
                if (knowTrue[num]) {
                    canLie = false;
                    break;
                }
            }
            if(canLie) result++;
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }

}
