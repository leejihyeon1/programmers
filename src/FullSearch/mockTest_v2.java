package FullSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 완전탐색 - 모의고사
//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
//가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
public class mockTest_v2 {
    //1.문제를 단순하게 하기
    public int[] solution(int[] answers) {
        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};

        int idx=0;
        int st1Cnt = 0;
        int st2Cnt = 0;
        int st3Cnt = 0;

        while(idx < answers.length){
            if(answers[idx] == st1[idx%st1.length]){
                st1Cnt++;
            }
            if(answers[idx] == st2[idx%st2.length]){
                st2Cnt++;
            }
            if(answers[idx] == st3[idx%st3.length]){
                st3Cnt++;
            }

            idx++;
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(Math.max(st1Cnt,st2Cnt),st3Cnt);
        if(max == st1Cnt){
            list.add(1);
        }
        if(max == st2Cnt){
            list.add(2);
        }
        if(max == st3Cnt){
            list.add(3);
        }

        Collections.sort(list);//리스트 오름차순 정렬
        return list.stream().mapToInt(i->i).toArray();
    }
}