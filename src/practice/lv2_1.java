package practice;

//연습문제 - JadenCase 문자열 만들기
public class lv2_1 {
    public String solution(String s) {
        //문자열 순회하면서 flag 값으로 공백 만남여부 체크
        String answer = "";
        StringBuilder sb = new StringBuilder(s);
        boolean flag = true;//공백 만났는지 확인하는 flag

        for (int i=0; i<=s.length()-1; i++){
            char first = s.charAt(i);//맨 앞글자 추출

            //1.공백을 안만났고(첫번째문자가 아님) 대문자이면 소문자로 변경
            if(!flag && Character.isUpperCase(first)){
                char l = Character.toLowerCase(first);
                sb.setCharAt(i,l);
            }

            //2.공백 다음 문자면 대문자로 변경
            if(flag){
                char u = Character.toUpperCase(first);
                sb.setCharAt(i,u);
                flag = false;
            }

            //3.공백 만났으면 flag값 변경
            if(first == ' '){
                flag = true;
            }
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        lv2_1 jadenCase = new lv2_1();
        jadenCase.solution("for the last week");
    }
}