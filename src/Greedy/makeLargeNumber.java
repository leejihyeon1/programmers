package Greedy;

import java.util.Stack;

//그리디(탐욕법) - 큰 수 만들기
public class makeLargeNumber {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        //내림차순 정렬해서 뒤에서 k개수대로 자르면 왜 안되지?
        //예시를 잘 보면 현재 문자열의 순서를 유지하고 있음

        Stack<Character> stack = new Stack<>();

        for (char num : number.toCharArray()) {
            while (!stack.isEmpty()
                    && stack.peek() < num
                    && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(num);
        }

        //k가 0이 되지 않은 경우
        while(k>0){
            stack.pop();//뒤쪽 숫자부터 제거(뒤쪽으로 갈수록 작아지기 때문)
            k--;
        }

        for(char c:stack){
            answer.append(c);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        makeLargeNumber largeNumber = new makeLargeNumber();
        largeNumber.solution("1924",2);
    }
}