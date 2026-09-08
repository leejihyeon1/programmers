package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

//2022 카카오 테크 인턴십 - 두 큐 합 같게 만들기
public class makeSameSum {
    public int solution(int[] queue1, int[] queue2) {
        //push와pop을 합쳐서 1회로 간주함
        int answer = 0;

        long queue1Sum = 0;
        long queue2Sum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<queue1.length; i++){
            //각 큐의 원소 합 구하기
            queue1Sum += queue1[i];
            queue2Sum += queue2[i];

            //큐에 담기
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        // System.out.println("avg"+avg);
        while(queue1Sum != queue2Sum){
            if(queue1Sum > queue2Sum){//queue1이 더 클 때
                // System.out.println("q1 더 큼"+queue1Sum);
                queue1Sum -= q1.peek();
                queue2Sum += q1.peek();
                q2.offer(q1.poll());

            }else{//queue2가 더 클 때
                // System.out.println("q2 더 큼"+queue2Sum);
                queue2Sum -= q2.peek();
                queue1Sum += q2.peek();
                q1.offer(q2.poll());

            }

            answer++;


            //넉넉한 시도 후 실패 판정을 내려야하기 때문에
            //단순 (queue1.length + queue2.length) 인 경우엔 너무 타이트 함.
            //따라서 2,3배 넉넉하게 시도할 수 있게끔 함
            if(answer > (queue1.length + queue2.length) * 3){
                return -1;
            }
        }


        return answer;
    }
}