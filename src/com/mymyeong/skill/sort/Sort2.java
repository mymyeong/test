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

//                    int a1 = v1

//                    int max = Math.max(v1, v2);
//
//                    int a3 = getNumber(v1, (int) (Math.log10(max) + 1));
//                    int a4 = getNumber(v2, (int) (Math.log10(max) + 1));
//
//                    if (a3 == a4) {
//                        if(v1 > v2 ) {
//                            return 1;
//                        } else if(v1 == v2 ) {
//                            return 0;
//                        } else {
//                            return -1;
//                        }
//                    } else if (a3 > a4) {
//                        return -1;
//                    } else {
//                        return 1;
//                    }
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

    public static int getNumber(Integer i, int length) {
//        int l = i.toString().length();
        int l = (int) (Math.log10(i) + 1);

        return (int) (i * Math.pow(10, length - l));
    }

    public static void main(String[] args) {
//        System.out.println(getLeft(123));
//        System.out.println(getLeft(12, 3));

//        System.out.println(getNumber(1, 3));
//        System.out.println(getNumber(12, 3));
//        System.out.println(getNumber(123, 3));

//        System.out.println(numberStirngTrim("00100"));

        int[] p1 = new int[]{3, 30, 34, 33, 29};
        System.out.println(new Sort2().solution(p1));

//        int[] p2 = new int[]{0, 0};
//        System.out.println(new Sort2().solution(p2));
    }
}
