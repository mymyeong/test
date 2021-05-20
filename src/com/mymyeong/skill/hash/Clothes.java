package com.mymyeong.skill.hash;

import java.util.HashMap;

public class Clothes {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0 ; i < clothes.length ; i++) {
           map.merge(clothes[i][1], 1, Integer::sum);
        }

        int answer = 0;

        for(String key : map.keySet()) {
            //System.out.println(key + map.get(key));
            answer = (answer + map.get(key)) + (answer * map.get(key));
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String temp1[][] = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(temp1);
        String temp2[][] = 	{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        solution(temp2);
    }
}
