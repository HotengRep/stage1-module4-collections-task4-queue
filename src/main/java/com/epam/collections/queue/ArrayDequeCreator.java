package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {

        ArrayDeque<Integer> bankOfCards = new ArrayDeque<>();

        initialGame(firstQueue,bankOfCards);
        initialGame(secondQueue,bankOfCards);

        while (!firstQueue.isEmpty() || !secondQueue.isEmpty())
        {
            if(!firstQueue.isEmpty())
            {
                firstStep(bankOfCards,firstQueue);
                secondStep(firstQueue,bankOfCards);
            }
            if(!secondQueue.isEmpty())
            {
                firstStep(bankOfCards,secondQueue);
                secondStep(secondQueue,bankOfCards);
            }
        }



        return  bankOfCards;

    }

    public  void initialGame(Queue<Integer> sourceDeck, ArrayDeque<Integer> targetDeck)
    {
        //Queue<Integer> tempDeck = new ArrayDeque<>(sourceDeck);
        targetDeck.add(sourceDeck.remove());
        targetDeck.add(sourceDeck.remove());
    }

    public void firstStep(ArrayDeque<Integer> sourceDeck, Queue<Integer> targetDeck)
    {
        targetDeck.add(sourceDeck.pollLast());
    }

    public void secondStep(Queue<Integer> sourceDeck, ArrayDeque<Integer> targetDeck)
    {
        targetDeck.add(sourceDeck.remove());
        if(sourceDeck.isEmpty()) {return;}
        targetDeck.add(sourceDeck.remove());
    }
}
