package practice;

// 연습문제 - 최솟값과 최댓값
public class lv2_3 {
    public String solution(String s) {
        String[] stringAnswer = s.split(" ");
        int[] answerArr = new int[stringAnswer.length];

        //문자열 배열을 숫자 배열로 변경
        for(int i=0; i<stringAnswer.length; i++){
            answerArr[i] = Integer.parseInt(stringAnswer[i]);
        }

        int min=answerArr[0];
        int max=answerArr[0];

        //숫자 비교
        for(int i=0; i<answerArr.length; i++){
            min = Math.min(min,answerArr[i]);
            max = Math.max(max,answerArr[i]);
        }

        return String.valueOf(min)+" "+String.valueOf(max);
    }
}