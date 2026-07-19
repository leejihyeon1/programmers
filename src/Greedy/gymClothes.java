package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//탐욕법(greedy) - 체육복
public class gymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        //0.체육복이 있는 학생  = 전체 - 잃어버린 학생
        int answer = n-lost.length;

        //배열 오름차순 정리
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여분도 있고 잃어버린 학생의 경우 계산
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if(reserve[i] == lost[j]){
                    answer++;//본인 카운트 추가
                    //-1로 확인 표시
                    reserve[i] = -1;
                    lost[j] = -1;
                    break;
                }
            }
        }

        //lost 배열에 reserve의 앞,뒤 번호가 있는지 확인
        for (int i = 0; i < reserve.length; i++) {
            if(reserve[i] == -1) continue;

            for (int j = 0; j < lost.length; j++) {
                if(lost[j] == -1) continue;

                if (lost[j]== reserve[i] - 1 || lost[j] == reserve[i] + 1) {
                    //카운트 증가
                    answer++;
                    //확인 표시
                    lost[j] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}