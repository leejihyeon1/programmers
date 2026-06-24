package DfsBfs;

// 깊이/너비 우선 탐색(DFS/BFS) - 네트워크
// 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
// 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
public class network {
    //1. 문제를 단순하게 하기
    // todo : 미해결문제 , 추후에 다시 해결해야함
    public int solution(int n, int[][] computers) {
        //본인은 무조건 1 ex) computers[i][i] = 1
        //visited false개수가 네트워크 개수
        boolean[] visited = new boolean[n];

        for (int i=0; i< computers.length; i++){
            for(int j=0; j<computers[i].length;j++){
                if(i == j){
                    continue;
                }
                if(computers[i][j] == 1){
                    visited[i] = true;
                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        network network = new network();
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        network.solution(n,computers);
    }
}