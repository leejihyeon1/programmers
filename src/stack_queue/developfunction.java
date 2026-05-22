package stack_queue;

// 스택/큐 - 기능개발
//각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
//이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
//먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
//각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class developfunction {
    //1. 문제를 단순하게 하기
    public int[] solution(int[] progresses, int[] speeds) {

        //앞에서부터 순서대로 비교 후 배포 하니까 Queue가 잘 맞음
        //Queue : 선입선출
        //Stack : 후입선출
        Queue<Integer> queue = new LinkedList<>();

        //2. 각 기능이 완료까지 걸리는 날짜 계산 후 큐에 저장 (올림 필수!)
        //(100-progress)/speed
        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];//정수 나눗셈은 소수점 버림

            if(remain % speeds[i] != 0){//소수점이 있다면 무조건 올림
                day++;
            }

            queue.offer(day);//offer()은 넣기
        }

        //3. 앞 날짜랑 비교해서 더 작으면 카운트 증가
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int current = queue.poll();//poll()은 꺼내기 (큐니까 맨앞이 꺼내면서 제거)
            int count = 1;//맨앞에 하나는 이미 배포 확정이라 1부터 시작

            //4. 뒤 기능들도 함께 배포 가능한지 확인
            //위에서 poll() 했기 때문에 맨앞은 꺼내졌고 지금은 두번째가 맨앞인 상태
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.poll();
                count++;
            }
            result.add(count);
        }

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}