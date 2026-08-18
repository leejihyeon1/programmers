package FullSearch;

import java.util.Arrays;

// 완전탐색 - 최소직사각형
// 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다.
// 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
// 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
public class minimumRectangle_v2 {
    //1.문제를 단순하게 하기
    public int solution(int[][] sizes) {
        //가로,세로 중 긴 변과 짧은 변 중에 최댓값 구하기(모든 명함이 다 들어가야하기때문에 최댓값)
        int answer = 0;
        int[] maxArr = new int[sizes.length];//긴 변은 가로로 통일
        int[] minArr = new int[sizes.length];//짧은 변은 세로로 통일

        for(int i=0; i<sizes.length; i++){
            int max = Math.max(sizes[i][0],sizes[i][1]);
            int min = Math.min(sizes[i][0],sizes[i][1]);

            maxArr[i] = max;
            minArr[i] = min;
        }

        Arrays.sort(maxArr);
        Arrays.sort(minArr);

        answer = maxArr[maxArr.length-1] * minArr[minArr.length-1];
        return answer;
    }
}