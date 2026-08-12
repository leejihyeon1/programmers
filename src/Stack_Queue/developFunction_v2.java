package Stack_Queue;

// 스택/큐 - 기능개발
//각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
//이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
//먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
//각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class developFunction_v2 {
    //1. 문제를 단순하게 하기
    public int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();//배포까지 걸리는 시간
        List<Integer> list = new ArrayList<>();//배포 기능 개수 저장용
        int num = (int)Math.ceil((double)(100-progresses[0])/speeds[0]);
        stack.push(num);

        int cnt =1;
        for(int i=1; i<progresses.length; i++){
            num = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            if(stack.peek() >= num){
                cnt++;
            }else{
                list.add(cnt);
                cnt = 1;
                stack.push(num);
            }

            //마지막 기능이라면 더이상 비교 대상이 없으니까 리스트 추가
            if(i==progresses.length-1){
                list.add(cnt);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}