package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

//스택/큐 - 다리를 지나는 트럭
public class truck_v2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //다리 길이만큼 0으로 채우기
        Queue<Integer> bridge = new LinkedList<>();
        while(bridge.size() < bridge_length){
            bridge.offer(0);
        }

        //트럭 대기열 큐로 변환
        Queue<Integer> truck = new LinkedList<>();
        for(int t:truck_weights){
            truck.offer(t);
        }

        int totalWeight = 0;
        int answer = 0;
        while(!bridge.isEmpty()){
            if(!truck.isEmpty()){
                //다리 무게 체크
                if(totalWeight+truck.peek() <= weight){
                    totalWeight -= bridge.poll();//앞에 하나 제거
                    totalWeight += truck.peek();
                    bridge.offer(truck.poll());//트럭에서 제거해서 다리에 올리기
                }else{
                    totalWeight -= bridge.poll();
                    if(totalWeight+truck.peek() <= weight){
                        totalWeight += truck.peek();
                        bridge.offer(truck.poll());
                    }else{
                        bridge.offer(0);
                    }
                }
                answer++;
            }else{
                bridge.poll();
                answer++;
            }
        }
        return answer;
    }
}