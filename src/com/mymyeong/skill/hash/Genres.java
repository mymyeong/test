package com.mymyeong.skill.hash;

import java.util.*;
import java.util.stream.IntStream;

public class Genres {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();

        for (int i = 0 ; i < genres.length ; i++)  {
            HashMap<String, Integer> temp = new HashMap<>();
            temp.put(String.valueOf(i), plays[i]);
            map.merge(genres[i], temp, (v1, v2) -> {
                v1.putAll(v2);
                return v1;
            });
        }

        int[] result = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue((e1, e2) -> { return e2.values().stream().flatMapToInt(IntStream::of).sum() - e1.values().stream().flatMapToInt(IntStream::of).sum(); }))
            .collect(LinkedHashMap::new, (m1, m2) -> {
                m2.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue((e1, e2) -> {return e2 - e1;} ))
                .limit(2)
                .forEach(v -> m1.put(v.getKey(), v.getValue())); }, LinkedHashMap::putAll).entrySet().stream()
            .collect(ArrayList::new, (e1, e2) -> {
                e1.add(Integer.parseInt((String) e2.getKey()));
            }, ArrayList::addAll)
            .stream().mapToInt(i -> (int) i).toArray()
        ;

        return result;
    }

    public static void main(String[] args) {
        String genres[] = {"classic", "pop", "classic", "classic", "pop"};
        int plays[] = {500, 600, 150, 800, 2500};

        solution(genres, plays);
//        Arrays.stream(solution(genres, plays)).forEach(System.out::println);
    }
}
