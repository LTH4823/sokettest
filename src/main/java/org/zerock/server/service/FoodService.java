package org.zerock.server.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodService {

    private List<String> foodNames;

    public FoodService(){
        foodNames = new ArrayList<>();
        foodNames.add("음식1");
        foodNames.add("음식2");
        foodNames.add("음식3");
        foodNames.add("음식4");
        foodNames.add("음식5");
    }

    public List<String> recommand(){
        Collections.shuffle(foodNames);
        return foodNames.subList(0,3);
    }
}
