package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

//스택/큐 - 프로세스
//location번째에 해당하는 원소가 최종적으로 몇번째로 실행되는지
public class process_v2 {
    public int solution(int[] priorities, int location) {
        //1.초기 실행 순서와 우선 순위를 같이 저장
        //2.우선순위 별 최종 실행 순서 나열
        //실행할땐, answerQueue에 임시 저장
        //3.answerQueue에서 location의 실행 순서 확인
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> answerQueue = new LinkedList<>();

        int num=0;
        for(int i :priorities){
            queue.offer(new int[]{num,i});
            num++;
        }

        while(!queue.isEmpty()){
            int[] q = queue.poll();
            boolean flag = false;
            for(int[] priority : queue){
                if(q[1] < priority[1]){
                    flag = true;
                    break;
                }
            }

            if(flag){
                queue.offer(q);
            }else{
                answerQueue.offer(q);
            }

        }

        //정답 추출
        int answer=0;
        for(int[] a:answerQueue){
            answer++;
            if(location == a[0]){
                break;
            }
        }
        return answer;
    }
}