package com.mymyeong.skill.hash;

import java.util.Arrays;

class Participant {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0 ; i < participant.length-1 ; i++ ) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[participant.length-1];
    }
}