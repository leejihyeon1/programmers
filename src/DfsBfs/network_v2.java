package DfsBfs;

// 깊이/너비 우선 탐색(DFS/BFS) - 네트워크
// 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
// 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
public class network_v2 {
    //1. 문제를 단순하게 하기
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i,n,computers);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int current, int n, int[][] computers){
        visited[current] = true;
        for(int next =0; next<n; next++){
            if(computers[current][next] == 1
                    && !visited[next]){
                dfs(next,n,computers);
            }
        }
    }
}