package Stack_Queue;

import java.util.*;

//연습문제 - 뒤에 있는 큰 수 찾기
public class FindLargeNumber {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        //뒷순서 기준으로 앞을 비교하니까 stack
        Stack<Integer> stack = new Stack<>();
        stack.push(0);//초기 값 세팅

        //stack에 있는 수가 나보다 작은지 비교
        for(int i=1; i<numbers.length; i++){
            //자기보다 작은 수 스택에서 빼기
            while(!stack.isEmpty()
                    && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);//본인 스택에 추가
        }

        //자기보다 큰 수를 만나지 못한 수에 대한 처리
        while (!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        FindLargeNumber lv2_22 = new FindLargeNumber();
        lv2_22.solution(new int[]{9, 1, 5, 3, 6, 2});
    }
}