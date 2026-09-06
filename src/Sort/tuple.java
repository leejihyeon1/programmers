package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//2019 카카오 개발자 겨울 인턴십 - 튜플
public class tuple {
    public int[] solution(String s) {

        //중괄호 제거
        s=s.replace("{","");
        s=s.replace("}","");

        //각 원소 데이터의 빈도수 순으로 정렬됨
        HashMap<String,Integer> map = new HashMap<>();
        String[] arr = s.split(",");

        for(int i=0; i<arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        //빈도수(value)가 큰 순으로 key 값 정렬
        List<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));


        int[] answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}