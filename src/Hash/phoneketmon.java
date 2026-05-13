package Hash;

//해시 - 폰켓몬
//당신은 폰켓몬을 잡기 위한 오랜 여행 끝에, 홍 박사님의 연구실에 도착했습니다.
//홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
//최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
//N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중,
//가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.

import java.util.HashSet;

public class phoneketmon {
    //1. 문제를 간단하게 만들기!!
    public int solution(int[] nums) {
        int answer = 0;
        //1. 중복 제거 (실질적인 폰켓몬 종류의 수)
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        //2. 중복 제거 수랑 nums/2 랑 비교해서 더 작은 값 선택
        //ex)[3,3,3,2,2,2]인 경우 3종류(nums/2) 선택 가능, 중복 제거하면 가능한 종류는 2종류
        //따라서, 작은 값을 선택해야함
        answer = Math.min(set.size(), nums.length);
        return answer;
    }
}