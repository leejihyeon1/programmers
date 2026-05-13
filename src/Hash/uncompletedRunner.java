package Hash;

//해시 - 완주하지 못한 선수
//수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
//
//마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
//완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

import java.util.HashMap;
import java.util.Map;

public class uncompletedRunner {
    //1. 문제를 간단하게 만들기!!!!!!!
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        //2. participant 배열을 순회하면서 참가자 이름을 map에 저장
        // 존재하지않으면 0, 이름 넣을 때 +1 (동명이인 가능성 고려)
        for (String name : participant){
            map.put(name,map.getOrDefault(name,0)+1);
        }

        //3. map을 순회하면서 completion 완주자 이름이 있으면 -1
        //즉, 완주하지 못한 선수는 1, 완주하면 0
        for (String name : completion){
            map.put(name,map.get(name)-1);
        }

        //4. value가 1인 선수 이름 가져오기
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}