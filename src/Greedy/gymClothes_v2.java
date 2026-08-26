package Greedy;

import java.util.Arrays;

//탐욕법(greedy) - 체육복
public class gymClothes_v2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 수업 들을 수 있는 학생 : 전체학생수 - 잃어버린 학생 수
        //체육복 빌린 학생 : 여벌 학생 번호 앞,뒤에 있는 학생
        //최댓값 : 수업 들을 수 있는 학생 + 빌린 학생

        int possible = n - lost.length;
        //혹시 모르니 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //for-each(향상된 for문)은 기존 배열을 복사해서 반복문 실행하기 때문에
        //기존 배열을 값을 변경 할 수 없음!!!
        //변경 하려면 일반 for문으로 해야됨

        //1. 도난 학생 = 여벌 있는 학생
        for(int i = 0; i < reserve.length; i++){
            for(int j = 0; j < lost.length; j++){
                if(reserve[i] == lost[j]){
                    reserve[i] = 0;
                    lost[j] = 0;
                    possible++;
                    break;
                }
            }
        }

        //2. 여벌 있는 학생 중 앞,뒤 번호 도난 학생 있으면 빌려줌
        for(int i = 0; i < reserve.length; i++){
            for(int j = 0; j < lost.length; j++){

                if(reserve[i] != 0 && lost[j] != 0){

                    if(reserve[i] - 1 == lost[j]
                            || reserve[i] + 1 == lost[j]) {

                        reserve[i] = 0;
                        lost[j] = 0;
                        possible++;
                        break;
                    }
                }
            }
        }
        return possible;
    }
}