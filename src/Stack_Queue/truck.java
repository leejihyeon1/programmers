package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

//스택/큐 - 다리를 지나는 트럭
public class truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;

        Queue<Integer> bridge = new LinkedList();
        //최초 다리 위에 0 세팅
        for(int i=0; i<bridge_length; i++){
            bridge.offer(0);
        }

        int currentWeight = 0;//현재 다리 위의 모든 트럭의 무게 합

        while(!bridge.isEmpty() && idx <= truck_weights.length-1){
            answer++;//최초 1초 경과

            currentWeight -= bridge.poll();  //현재 다리 위 트럭 무게 = 현재 - 다리를 나온 트럭

            //다리 위의 모든 트럭 무게 + 새로 합류할 트럭 무게 <= weight
            if(currentWeight + truck_weights[idx] <= weight){
                bridge.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            }else{
                bridge.offer(0);
            }
        }

        //다리 위로 트럭을 다 올렸다면(truck_weighs == idx)
        //마지막 트럭이 다리를 통과할때까지 계산
        while(idx == truck_weights.length && !bridge.isEmpty()){
            bridge.poll();
            answer++;
        }

        return answer;
    }
}