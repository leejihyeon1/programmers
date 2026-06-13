package FullSearch;

import java.util.ArrayList;
import java.util.List;

// 완전탐색 - 모의고사
//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
//가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
public class mockTest {
    //1.문제를 단순하게 하기
    public int[] solution(int[] answers) {
        //2.학생 별 제출한 정답 패턴 저장
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int p1Cnt = 0;
        int p2Cnt = 0;
        int p3Cnt = 0;

        //3.실제 정답과 맞는지 비교 후 정답 카운트 증가
        for(int i=0; i<answers.length; i++){
            if(p1[i % p1.length] == answers[i]){
                p1Cnt++;
            }
            if(p2[i % p2.length] == answers[i]){
                p2Cnt++;
            }
            if(p3[i % p3.length] == answers[i]){
                p3Cnt++;
            }
        }

        //4.정답을 많이 맞춘 학생 번호 배열에 담기
        List<Integer> answerList = new ArrayList<>();

        int max = Math.max(p1Cnt,Math.max(p2Cnt,p3Cnt));

        if (max == p1Cnt) {
            answerList.add(1);
        }
        if (max == p2Cnt) {
            answerList.add(2);
        }
        if (max == p3Cnt) {
            answerList.add(3);
        }
        int[] answer = new int[answerList.size()];
        for(int i=0; i< answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}