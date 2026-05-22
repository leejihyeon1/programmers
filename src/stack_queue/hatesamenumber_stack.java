package stack_queue;

// 스택/큐 - 같은 숫자는 싫어
//배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
import java.util.Stack;

public class hatesamenumber_stack {
    //1. 문제 간단하게 만들기
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr){
            if(stack.isEmpty()){
                stack.push(num); //최초 값 추가
            }else if(stack.peek() != num){
                stack.push(num);
            }
        }

        int[] answer = new int[stack.size()];
        for(int i=0; i<stack.size(); i++){
            answer[i] = stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        hatesamenumber_stack test = new hatesamenumber_stack();
        int[] arr = new int[]{1,1,3,3,0,1,1};
        test.solution(arr);
    }
}