package Hash;

//해시 - 의상
//코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.
//코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

import java.util.*;

public class clothes {
    //1.문제를 간단히 하기!
    public int solution(String[][] clothes) {
        int answer = 1;
        //2. 옷 종류 별로 구분하기
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0; i<clothes.length; i++){
            String name = clothes[i][0];
            String type = clothes[i][1];

            map.putIfAbsent(type,new ArrayList<>());
            map.get(type).add(name);
        }

        //3. 경우의 수 구하기
        for(List<String> value : map.values()){
            answer *= (value.size()+1);
        }

        //4. 모자나 안경을 안쓰는 경우를 빼야함(중요!!!!)
        return answer-1;
    }
}