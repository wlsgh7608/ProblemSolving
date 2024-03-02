import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int p = 0;
        int q = people.length - 1;

        int cnt = 0;
        while(p<=q){
            int lightOne = people[p];
            int heavyOne = people[q];
            if(lightOne + heavyOne <= limit){
                p++;
                q--;
            }else{
                q--;
            }
            cnt++;

        }
        return cnt;
    }
}