package practice;

import java.util.*;

//연습문제 - 귤 고르기
//hashMap + 정렬 문제
public class lv2_10 {
    public int solution(int k, int[] tangerine) {
        //1. 귤 크기 별 개수를 샌다
        HashMap<Integer,Integer> map = new HashMap<>();
        //크기 별 귤 개수 저장
        for(int i:tangerine){
            if(map.containsKey(i)){//key가 있다면 value+1
                map.put(i,map.get(i)+1);
            }
            map.putIfAbsent(i,1); //key가 없다면 새로 생성
        }
        //2. 개수가 많은 크기부터 선택한다
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());//value 값 내림차순 정렬

        int answer = 0;//종류 수 저장

        for(int count : list){
            k -= count;
            answer++;

            if(k <=0) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        lv2_10 lv2_10 = new lv2_10();
        int[] tangerine = {'1','3','2','5','4','5','2','3'};
        lv2_10.solution(6,tangerine);
    }
}