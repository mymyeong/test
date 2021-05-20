package com.mymyeong.skill.hash;

import java.util.Arrays;
import java.util.List;

public class Phone {
    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1 ; i++) {
            if (phone_book[i+1].indexOf(phone_book[i]) == 0) {
                return false;
            }
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] phones = {"119", "97674223", "1195524421"};
        System.out.println(solution(phones));
        phones = new String[]{"123", "456", "789"};
        System.out.println(solution(phones));
    }
}
