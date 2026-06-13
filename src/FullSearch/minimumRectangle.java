package FullSearch;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;

// 완전탐색 - 최소직사각형
// 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다.
// 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
// 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
public class minimumRectangle {
    //1.문제를 단순하게 하기
    public int solution(int[][] sizes) {
        //2.**  배열 중 큰 값은 가로 , 작은 값은 세로로 기준 통일!!
        // 즉 가로 세로가 중요한게 아닌 배열에서 큰 값을 구하는게 중요
        int maxWidth = 0;
        int maxHeight = 0;

        //항상 가로,세로 값 두개만 입력되기 때문에 한 배열당 사이즈는 2로 고정임
        for(int i=0; i< sizes.length; i++){
            int width = Math.max(sizes[i][0],sizes[i][1]);
            int height = Math.min(sizes[i][0],sizes[i][1]);

            maxWidth = Math.max(maxWidth,width);
            maxHeight = Math.max(maxHeight,height);
        }

        //3. 가로 값,세로 값 중 가장 큰 값 구하기
        //4. 가로x세로 해서 지갑의 크기 구하기
        int answer = maxWidth * maxHeight;
        return answer;
    }

    public static void main(String[] args) {
        minimumRectangle minimumRectangle = new minimumRectangle();
        int[][] sizes = new int[][]{{60, 50},{30, 70},{60, 30},{80, 40}};
        minimumRectangle.solution(sizes);
    }
}