package Stack_Queue;

import java.util.Stack;

//스택/큐 - 올바른 괄호
//'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true,
// 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
public class correctbracket {
    //1.문제를 단순하게 하기
    boolean solution(String s) {
        boolean answer = true;
        //가장 최근에 열린 괄호랑 짝을 맞추기때문에 stack(후입선출)
        //문자열 한 글자씩이니까 character형
        Stack<Character> stack = new Stack<>();
        //2.( 나오면 스택에 push
        //3.) 나오면 스택에서 pop
        //즉, pop할게 없으면 짝이 안맞는 괄호임!
        //스택이 중간에 비었거나, 최종으로 값이 남아있는 것은 짝이 안맞음

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else if (c == ')'){
                //스택이 비었으면 짝이 안맞는 것
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                stack.pop();//가장 마지막꺼 제거

            }
        }
        //스택에 괄호가 남아있으면 짝이 안맞는것
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}