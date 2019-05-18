package xyz.devrj.butterbrawl.actions;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class MapOrder {

    public static Map<String, Integer> orderDescending(Map<String, Integer> inputMap){
        Map<String, Integer> resultMap = inputMap
                            .entrySet()
                            .stream()
                            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                            .collect(
                                    toMap(stringIntegerEntry -> stringIntegerEntry.getKey(),
                                            stringIntegerEntry -> stringIntegerEntry.getValue(),
                                            (e1, e2) -> e2,
                                            () -> new LinkedHashMap<String, Integer>()));

        return resultMap;
    }
}
