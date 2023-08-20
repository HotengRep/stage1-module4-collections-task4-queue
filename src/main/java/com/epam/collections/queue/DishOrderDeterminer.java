package com.epam.collections.queue;

import java.util.LinkedList;
import java.util.List;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {

        LinkedList<Integer> allDishes = new LinkedList<>();
        int delta = 0;
        for(int i = 1; i <= numberOfDishes; i++)
        {
            allDishes.addLast(i);
        }
        LinkedList<Integer> orderDishes = new LinkedList<>();
        int combinedValue = everyDishNumberToEat-1;
        while (orderDishes.size() != numberOfDishes){

            orderDishes.addLast(combinedValue-delta < allDishes.size() ? allDishes.get(combinedValue-delta): allDishes.getFirst());
            allDishes.remove(combinedValue-delta < allDishes.size() ? combinedValue - delta: 0);

            combinedValue += everyDishNumberToEat;
            delta += 1;

            if(combinedValue >= allDishes.size() + delta )
            {
                combinedValue = getNextIndex(allDishes.size(), combinedValue-delta);
                delta = 0;
            }
        }

        return orderDishes;
    }

    public int getNextIndex(int size, int currentIndex)
    {
            return  currentIndex - size;
    }
}
