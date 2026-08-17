package Sort;

//정렬 - 가장 큰 수
//0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
// return 하도록 solution 함수를 작성해주세요.

import java.util.Arrays;

public class biggestNumber_v2 {
    //1.문제를 간단하게 하기
    public String solution(int[] numbers) {
        //이어붙이기 위해 문자열로 변환
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            str[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(str,(a,b)->(b+a).compareTo(a+b));

        //맨앞이 0인 경우 000->0으로 처리 필요
        if(str[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(s);
        }

        return sb.toString();
    }
}