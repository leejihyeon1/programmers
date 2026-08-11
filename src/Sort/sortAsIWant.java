package Sort;

import java.util.Arrays;

//연습문제 - 문자열 내 마음대로 정렬하기
public class sortAsIWant {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,(a,b)->{//람다식에는 정렬 기준만 명시
            if(a.charAt(n) == b.charAt(n)){//글자가 같다면 문자열 자체 비교
                return a.compareTo(b);
            }
            return Character.compare(a.charAt(n),b.charAt(n));//글자끼리 비교
        });
        return strings;
    }
}