package practice;

//월간 코드 챌린지 시즌1 - 이진 변환 반복하기
public class lv2_4 {
    public int[] solution(String s) {
        //1.s에서 0 전부 제거
        //제거된 0의 개수 누적
        int deleteNum = 0;
        int binaryNum = 0;
        String binary = "";
        while (!s.equals("1")){
            for(int i=0; i<=s.length()-1; i++){
                if(s.charAt(i) == '0'){
                    deleteNum++;
                }
            }
            s = s.replaceAll("0","");
            //2.1번 이후 문자열 수 확인
            int length = s.length();

            //3.2번 수 만큼 2진수로 변환
            //최종 1이 될때까지 반복
            binaryNum++;
            s = Integer.toBinaryString(length);//10진수 -> 2진수 변환 함수
        }

        //4. 1~3번까지의 과정 횟수 누적
        int[] answer = {binaryNum,deleteNum};
        return answer;
    }

    public static void main(String[] args) {
        lv2_4 lv24 = new lv2_4();
        lv24.solution("110010101001");
    }
}