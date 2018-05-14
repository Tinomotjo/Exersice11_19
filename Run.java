package Exersice11_19;
import java.util.*;
/*
Write a method called rarest that accepts a map whose keys are strings and
whose values are integers as a parameter and returns the integer value that
occurs the fewest times in the map. If there is a tie, return the smaller integer value.
If the map is empty, throw an exception
 */
public class Run {
    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();

        map1.put("Tino", 5);
        map1.put("Lort", 8);
        map1.put("Kage", 30);
        map1.put("Hej", 12);
        map1.put("MartinLugter", 9);
        map1.put("YOLO", 15);

        System.out.println("Den value som går igen færrest gange er:  " + rarest(map1));
    }

    public static int rarest (Map<String, Integer> map) {

        Map<Integer, Integer> map2 = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int num = map.get(entry.getKey());
            if (map2.containsKey(num)) {
                map2.put(num, map2.get(num) + 1);
            } else {
                map2.put(num, 1);
            }
        }

        Set<Integer> set = map2.keySet();
        Iterator<Integer> i = set.iterator();
        Integer min = i.next();


        while(i.hasNext()) {
            Integer current = i.next();
            if (map2.get(current) < map2.get(min)) {
                min = current;
            }
        }
        return min;
    }
}