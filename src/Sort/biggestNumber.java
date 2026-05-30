package Sort;

//정렬 - 가장 큰 수
//0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
// return 하도록 solution 함수를 작성해주세요.

import java.util.Arrays;

public class biggestNumber {
    //1.문제를 간단하게 하기
    public String solution(int[] numbers) {
        //2.문자열로 변환
        String[] strings = new String[numbers.length];
        for (int i = 0; i<numbers.length; i++){
            strings[i] = Integer.toString(numbers[i]);
        }
        //3.가장 큰 수를 만들게끔 정렬하기
        Arrays.sort(strings,(a,b)->(b+a).compareTo(a+b));

        //4.정렬된 숫자 이어 붙이기
        String answer = "";
        for(String st : strings){
            answer += st;
        }
        //5.예외 처리 (정렬 후 맨앞이 0이면 000이 아닌 0으로 나오도록)
        if(strings[0].equals("0")){
            return "0";
        }
        return answer;
    }

    public static void main(String[] args) {
        biggestNumber biggestnumber = new biggestNumber();
        int[] arr = new int[]{6, 10, 2};
        biggestnumber.solution(arr);
    }
}