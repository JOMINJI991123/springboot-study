package com.example.hongtack.ioc;

import org.springframework.stereotype.Component;

@Component
public class Chef {
    private IngredientFactory ingredientFactory;

    public Chef(IngredientFactory ingredientfactory) {
        this.ingredientFactory = ingredientfactory;
    }
    public String cook(String menu) {

        Ingredient ingredient = ingredientFactory.get(menu);

        return ingredient.getName() + "으로 만든 "+menu;
    }
}
