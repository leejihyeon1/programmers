package Greedy;

import java.util.Arrays;

//탐욕법(greedy) - 구명보트
public class boat_v2 {
    public int solution(int[] people, int limit) {
        //무거운순, 가벼운순으로 정렬 후 매칭
        //limit을 넘기면 무거운 사람 혼자 탐 (가장 가벼운 애랑 limit을 넘기면 누구든 limit을 넘기기 때문)
        int answer = 0;

        //오름차순 정렬
        Arrays.sort(people);

        //투포인터
        int left = 0;//가장 가벼운 무게
        int right = people.length - 1;//가장 무거운 무게

        while(left <= right){
            int sum = people[left]+people[right];

            if(sum <= limit){
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}