package xyz.devrj.butterbrawl.actions;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculations {

    public static List<Integer> calculatePercents(List<Integer> currentWeights, List<Integer> startingWeights){

        List<Integer> weightPercents = new ArrayList<>();

        for(int i = 0; i < currentWeights.size(); i++){
//            Convert to INT and save
            BigDecimal result = new BigDecimal(((double)startingWeights.get(i) - (double)currentWeights.get(i)) / (double)startingWeights.get(i) * 100);
            weightPercents.add(result.intValue());
        }

        return weightPercents;
    }

}
