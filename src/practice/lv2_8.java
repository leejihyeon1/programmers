package practice;

import java.util.Stack;

//2017 팁스타운 - 짝지어 제거하기
public class lv2_8 {
    public int solution(String s) {
        //1.문자열에서 각 단어로 분리
        //지금 넣는 값이 기존 값과 같은지 비교하려면 스택 사용해야함
        Stack<String> stack = new Stack<>();
        for(String item : s.split("")){
            if(stack.isEmpty()){
                stack.push(item);
                continue;
            }

            //2.스택에 값을 넣기 전 스택 마지막 값과 현재 넣으려는 값이 같은지 비교
            //같다면 pop, 없다면 push
            if(stack.peek().equals(item)){
                stack.pop();//마지막 값 제거
            }else{
                stack.push(item);
            }
        }

        //3.스택에 남은 값 확인
        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        lv2_8 lv28 = new lv2_8();
        lv28.solution("baabaa");

    }
}