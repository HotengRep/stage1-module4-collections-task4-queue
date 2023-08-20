package com.epam.collections.queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        Comparator<String> comparator = new ComparableString();
        double capacity = firstList.size()+secondList.size() > 0? (firstList.size()+secondList.size())*1.3: 1;
        PriorityQueue<String> priorQueue = new PriorityQueue<>((int)capacity,comparator);
        priorQueue.addAll(firstList);
        priorQueue.addAll(secondList);



        return  priorQueue;
    }


}

