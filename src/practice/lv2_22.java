package practice;

//연습문제 - 땅따먹기
//DP(동적계획법)
public class lv2_22 {
    public int solution(int[][] land) {
        //1.각 열마다 최대값이 나오는 경로를 구함
        int answer = 0;

        //열은 4개가 고정이기때문에 하드코딩
        for(int i=1; i<land.length; i++){
            land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }

        for(int i=0; i<4; i++){
            answer = Math.max(answer,land[land.length-1][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        lv2_22 lv2_22 = new lv2_22();
        int[][] arr = new int[][]{{1,2,3,5},{5,6,7,8}, {4,3,2,1}};
        lv2_22.solution(arr);
    }
}