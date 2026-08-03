package practice;

import java.util.*;

//연습문제 - 연속 부분 수열 합의 개수
//슬라이딩 윈도우 (전의 값을 이용하면서 한 칸씩 이동)
public class lv2_20 {
    public int solution(int[] elements) {
        //중복 제거 해야하니까 hashSet 사용
        HashSet<Integer> set = new HashSet<>();
        //연속 수열을 배열 이어붙이기로 표현
        int[] arr = new int[elements.length*2];
        for(int i=0; i<elements.length*2; i++){
            arr[i] = elements[i% elements.length];
        }


        //길이에 따른 수열 합 구하기
        for(int i=1; i<=elements.length; i++){//수열의 길이
            for(int j=0; j<elements.length; j++){//더하기를 어디서 시작할지
                int sum=0;
                for(int k=0; k<i; k++){//몇칸 이동해서 더할지
                    sum += arr[j+k];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}