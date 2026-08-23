package FullSearch;

import java.util.HashSet;

//완전탐색 - 소수 찾기
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
//종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
public class searchPrime_v2 {
    //1.문제를 단순하게 하기!
    //dfs에서 접근 가능하기 위한 전역변수화
    private String[] arr;
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        //1.가능한 숫자 조합을 만들기
        //2.조합 중에 소수 찾기
        int answer = 0;

        arr = numbers.split("");
        boolean[] visited = new boolean[arr.length];//각 조각 별 사용 여부
        dfs("",visited);
        return set.size();
    }

    private boolean isPrime(int num){
        //0,1은 포함안됨
        if(num <2) return false;

        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    //재귀 함수
    private void dfs(String st,boolean[] visited){
        if(!st.equals("")){
            int num = Integer.parseInt(st);
            if(isPrime(num)){
                set.add(num);
            }
        }

        for(int i=0; i<arr.length; i++){
            if(visited[i] == false){
                visited[i] = true;//사용 처리
                dfs(st+arr[i],visited);
                visited[i] = false;//다시 안 쓴 상태로 되돌리기(=백트래킹)
            }
        }
    }
}