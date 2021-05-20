package com.mymyeong.learn;

import java.time.LocalDateTime;

public class TimeExam {
    public static void main(String[] args){
        //지금이 몇월인지를 영어로(예. 1월이면 JANUARY, 2월이면 FEBRUARY) 출력하세요
        System.out.println(LocalDateTime.now().getMonth());
    }
}
