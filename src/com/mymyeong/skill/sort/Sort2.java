package com.mymyeong.skill.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sort2 {
    public String solution(int[] numbers) {

        return numberStirngTrim(Arrays.stream(numbers).mapToObj(v -> Integer.valueOf(v))//
                .sorted((v1, v2) -> {
                    if(v1 == v2 ) {
                        return 0;
                    }

                    Double a1 = Double.valueOf(String.valueOf(v1) + String.valueOf(v2));
                    Double a2 = Double.valueOf(String.valueOf(v2) + String.valueOf(v1));

                    if(a1 > a2 ) {
                        return -1;
                    }

                    return 1;

                })//
                .map(v -> String.valueOf(v))//
                .collect(Collectors.joining()));
    }

    public static String numberStirngTrim(String str) {
        if(str.length() > 1) {
            if(str.charAt(0) == '0' ) {
                return numberStirngTrim(str.substring(1));
            } else {
                return str;
            }
        }
        return str;
    }

    public static void main(String[] args) {

        int[] p1 = new int[]{3, 30, 34, 33, 29};
        System.out.println(new Sort2().solution(p1));

        int[] p2 = new int[]{0, 0};
        System.out.println(new Sort2().solution(p2));
    }
}
