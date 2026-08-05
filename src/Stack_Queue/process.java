package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

//스택/큐 - 프로세스
//location번째에 해당하는 원소가 최종적으로 몇번째로 실행되는지
public class process {
    public int solution(int[] priorities, int location) {
        //1.큐 세팅
        //2.비교해서 최종 실행 순서 배열 세팅
        //3.큐의 배열[0]가 location인 배열의 실행 순서 return

        //큐 세팅
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;

        for(int i=0; i<priorities.length; i++){
            queue.offer(new int[]{i,priorities[i]});//배열의 순서랑 우선순위 같이 저장
        }

        //비교 시작
        while(!queue.isEmpty()){
            int[] priority = queue.poll();
            boolean hasHigher = false;
            //queue는 collection을 구현하기 때문에 향상된 for문(for-each) 순회 가능
            //주의! 읽기엔 가능, 수정하면 예외 발생할 수 있음
            for(int[] process : queue){
                //나보다 큰 대기 숫자가 있는 경우
                if(process[1] > priority[1]){
                    hasHigher = true;
                    break;//한번 뒤로 보냈으면 이번 검사는 끝, 다음 검사로 넘어가야함
                }
            }
            if(hasHigher){
                queue.offer(priority);
            }else{
                answer++;

                if(priority[0] == location){
                    return answer;
                }
            }
        }
        return answer;
    }
}