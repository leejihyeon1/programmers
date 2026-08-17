package Stack_Queue;

import java.util.Stack;

//스택/큐 - 올바른 괄호
//'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true,
// 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
public class correctBracket_v2 {
    //1.문제를 단순하게 하기
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                if(stack.peek() == '('){
                    if(arr[i] == ')'){
                        stack.pop();
                    }else{
                        stack.push(arr[i]);
                    }
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}