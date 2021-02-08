package com.example.shopping_room.data.partialentities;

import java.util.Random;

public class ShoppingListInsert {
    public String id;
    public String name;
    public String category = generateCategory();

    public ShoppingListInsert(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String generateCategory() {
        String[] categories = new String[]{"Fitness", "Eventos", "Rápidas"};
        return categories[new Random().nextInt(3)];
    }
}