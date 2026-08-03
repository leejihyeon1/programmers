package practice;

//연습문제 - 행렬의 곱셈
public class lv2_19 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int cnt=0;
        //00*00 + 01*10 = answer[0][0]
        //00*01 + 01*11 = answer[0][1]
        //10*00 + 11*10 = answer[1][0]
        //10*01 + 11*11 = answer[1][1]
        for(int i=0; i<arr1.length; i++){//arr1의 몇번째 행?
            for(int j=0; j<arr2[0].length; j++){//arr2의 몇번째 열?
                for(int k=0; k<arr2.length; k++){//인덱스 역할
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}