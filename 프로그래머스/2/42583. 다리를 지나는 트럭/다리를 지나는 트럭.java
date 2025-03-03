import java.util.*;
import java.util.stream.*;
class Solution {
    private static class Truck{
        private int weight;
        private int position = 1;
        
        Truck(int weight){
            this.weight = weight;
        }
        
        public int getPosition(){
            return position;
        }
        
        public void move(){
            position++;
        }
        
        public int getWeight(){
            return weight;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int curr = 0;
        ArrayDeque<Truck> trucks = Arrays.stream(truck_weights)
            .mapToObj(Truck::new).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Truck> bridge = new ArrayDeque<>();
        while(!bridge.isEmpty() || !trucks.isEmpty()){
             // 연속적으로 진행한다고 하면 해당 시간 안에서 모두 처리해보는 생각을 한다.
            time++;
            if(!bridge.isEmpty()){
                for(Truck t : bridge){
                    t.move();
                }
            }
            
            if(!bridge.isEmpty() && bridge.peek().getPosition() > bridge_length){
                Truck out = bridge.poll();
                curr -= out.weight;
            }
            
            if(!trucks.isEmpty() && curr + trucks.peek().getWeight() <= weight && bridge.size() < bridge_length){
                Truck in = trucks.poll();
                bridge.add(in);
                curr += in.weight;
            }
        }   
        return time;
    }
}