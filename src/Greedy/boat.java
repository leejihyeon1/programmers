package Greedy;

import java.util.Arrays;

//탐욕법(greedy) - 구명보트
public class boat {
    public int solution(int[] people, int limit) {
        //구명보트를 최대한 적게 사용하여 사람들 구출(구명보트 최솟값 구하기)
        //1. 몸무게를 오름차순 정렬
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length-1;

        while(left <= right){
            int kg = people[left] + people[right];

            //둘이 함께 탑승
            if(kg <= limit){
                left++;
            }
            //혼자 탑승
            right--;

            //마지막 한번만 answer 카운트하는 이유는
            //둘이 타던, 혼자 타던 보트 수는 카운트 해야하기 때문
            answer++;
        }
        return answer;
    }
}