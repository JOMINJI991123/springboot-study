package com.example.hongtack.ioc;

import com.example.hongtack.ioc.Beef;
import com.example.hongtack.ioc.Ingredient;
import com.example.hongtack.ioc.Pork;
import org.springframework.stereotype.Component;

@Component
public class IngredientFactory {
    public Ingredient get(String menu) {
        switch (menu){
            case "돈가스":
                return new Pork("한돈 등심");
            case "스테이크":
                return new Beef("한우 꽃등심");
            case "크리스피 치킨":
                return new Chicken("국내산");
            default:
                return null;

        }
    }
}
