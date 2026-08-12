package Hash;

//해시 - 완주하지 못한 선수
//수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
//
//마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
//완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

import java.util.HashMap;
import java.util.Map;

public class uncompletedRunner_v2 {
    //1. 문제를 간단하게 만들기!!!!!!!
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        //참여자 map에 저장
        for(String p : participant){
            map.put(p,map.getOrDefault(p,0)+1);
        }

        //완주자 map에서 -1
        for(String c:completion){
            map.put(c,map.get(c)-1);
        }

        //keySet()해서 get(key)하는것보다 entrySet()이 더 효율적!
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue() >0){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}