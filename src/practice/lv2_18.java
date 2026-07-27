package practice;

import java.util.Stack;

//월간 코드 챌린지 시즌2 - 괄호 회전하기
public class lv2_18 {
    public int solution(String s) {
        //최초 한번은 매개변수 s 그대로 검사
        //그 이후부터 한번씩 회전
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for(int j=0; j<s.length(); j++){
            if(j > 0){
                s = s.substring(1)+s.charAt(0);
            }

            for(int i=0; i<s.length(); i++){
                //여는 괄호면 stack에 push
                if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                    stack.push(s.charAt(i));
                }else{//닫는 괄호인 경우 현재와 마지막이 같은 쌍인지 비교
                    if(!stack.isEmpty()){
                        if(s.charAt(i)==']' && stack.peek() == '[') stack.pop();
                        if(s.charAt(i)=='}' && stack.peek() == '{') stack.pop();
                        if(s.charAt(i)==')' && stack.peek() == '(') stack.pop();
                    }else{
                        break;
                    }
                }
                if (stack.isEmpty() && i == s.length()-1) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        lv2_18 lv218 = new lv2_18();
        lv218.solution("}]()[{");
    }
}