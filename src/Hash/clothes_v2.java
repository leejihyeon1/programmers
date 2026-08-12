package Hash;

//해시 - 의상
//코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.
//코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

import java.util.HashMap;
import java.util.Map;

public class clothes_v2 {
    //1.문제를 간단히 하기!
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        //경우의 수 : 각 한번씩 입기,안입기
        for(String s :map.keySet()){
            answer *= map.get(s)+1;//+1은 안입는 경우 추가한것
        }

        answer -= 1; //하나도 입지 않는 경우의 수를 제거
        return answer;
    }
}