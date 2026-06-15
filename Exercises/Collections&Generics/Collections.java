import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.w3c.dom.css.Counter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        List<String> names = List.of("Ana","Bob","Ana","Carlos","Bob","Bob");

        // HashMap: Is the fastest and order does not matter
        Map<String, Integer> map = new HashMap<>();

        for (String name: names) {
            map.put(
                name, 
                map.getOrDefault(name,0) + 1
            );
        }

        System.out.println(map);

        Map<String, Long> countsMap = 
            names.stream()
                .collect(
                    Collectors.groupingBy(
                        name -> name,
                        Collectors.counting()
                    )
                );

        System.out.println(countsMap);

        // Linked Hash Map: Slower than HashMap but faster than MapTree
        // preserve insertion order
        Map<String, Integer> linked = new LinkedHashMap<>();

        for (String name : names) {
            linked.put(
                name, 
                linked.getOrDefault(name, 0) + 1
            );
        }

        System.out.println(linked);

        Map<String, Long> countsLinked = 
            names.stream()
                .collect(
                    Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                    )
                );

        System.out.println(countsLinked);

        // TreeMap: Slower but keep keys sorted automatically
        Map<String, Integer> treeMap = new TreeMap<>();

        for(String name: names) {
            treeMap.put(
                name, 
                treeMap.getOrDefault(name, 0) + 1
            );
        }

        System.out.println(treeMap);

        Map<String, Long> treeCounts =
            names.stream()
                .collect(
                    Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting()
                    ));

        System.out.println(treeCounts);
    }
}
