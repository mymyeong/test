package com.mymyeong.learn;

import java.io.FileWriter;
import java.io.PrintWriter;

public class CharIOExam {
    public static void main(String[]args){

        System.out.println("안녕하세요. PrintWriter입니다.");
        try (PrintWriter pw = new PrintWriter(new FileWriter("data.txt")) ) {
            pw.println("안녕하세요. PrintWriter입니다.");
        } catch (Exception ex) {

        }
    }
}
