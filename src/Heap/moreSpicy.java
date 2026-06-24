package Heap;

import java.util.PriorityQueue;

// 힙 - 더 맵게
// Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
// 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
public class moreSpicy {
    //1. 문제를 단순하게 하기!!
    //공식대로 나온 답이 k보다 작으면 scoville 배열에 추가해서 다시 계산함
    public int solution(int[] scoville, int K) {
        //priority queue는 가장 작은 값이 맨 앞에 있음 (오름차순)
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;

        for(int s : scoville){
            queue.offer(s);// 우선순위 큐에 값 넣기(자동 오름차순 정렬됨)
        }

        //계속 큐에 값이 들어가기때문에 반복문의 횟수를 알 수 없어서 for 말고 while 써야함!
        while (queue.peek() < K){

            if(queue.size() < 2) return -1;

            int first = queue.poll(); //값을 꺼내고 제거되니까 두번째가 맨앞으로 옴
            int second = queue.poll();

            int newNum = first + (second * 2);

            queue.offer(newNum);
            answer++;

        }

        return answer;
    }
}