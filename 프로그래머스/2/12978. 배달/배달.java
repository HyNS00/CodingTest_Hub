import java.util.*;
class Solution {
    public static class Node{
        int to;
        int weight;
        
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        public int getTo(){
            return to;
        }
        
        public int getWeight(){
            return weight;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int[] distance = new int[N+1];
        // distance에는 최솟값들만 들어감
        Arrays.fill(distance, Integer.MAX_VALUE);
        List<List<Node>> list = new ArrayList<>();
        for(int i = 0; i < N+1; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] r : road){
            list.get(r[0]).add(new Node(r[1],r[2]));
            list.get(r[1]).add(new Node(r[0],r[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.getWeight() - b.getWeight());
        pq.add(new Node(1,0));
        distance[1] = 0;
        while(!pq.isEmpty()){
            Node n = pq.poll();
            
            int curr = n.getTo();
            int currD = n.getWeight();
            
            if(currD > distance[curr]) continue;
            
            for(Node node : list.get(curr)){
                int newDist = currD + node.weight;
                if(distance[node.getTo()] > newDist){
                    distance[node.getTo()] = newDist;
                    pq.add(new Node(node.getTo(), newDist));
                }
            }
        }
        for(int i = 2; i < distance.length; i++){
            if(distance[i] <= K) answer++;
        }
         return answer;
    }
   
}