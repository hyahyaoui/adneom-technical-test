package com.adneom.listpartitioner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author hyahyaoui
 */
public class ListPartioner {

    /**
     * Returns a list of consecutive sublist, having each one the same size (the final list may be smaller).
     * For example, partitioning a list containing {@code [a, b, c, d, e]} with a partition size of 3
     * will give {@code [[a, b, c], [d, e]]}
     *
     * @param list          the list to partition.
     * @param partitionSize the size of a partition.
     * @param <T>           the type of the input elements.
     * @return a list of consecutive sublist.
     * @throws IllegalArgumentException if the partition size is not greater than zero
     *                                  or the given list is empty or {@code null}
     */
    public static <T> List<List<T>> partition(List<T> list, int partitionSize) {

        checkPartitionSizeIsPositive(partitionSize);
        checkListNotEmpty(list);

        final AtomicInteger counter = new AtomicInteger(0);


        return list.stream()
                .collect(Collectors.groupingBy(element -> counter.getAndIncrement() / partitionSize))
                .values()
                .stream()
                .collect(toList());
    }

    private static <T> void checkListNotEmpty(List<T> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("The list to be partitioned must contain at least one element");
        }
    }

    private static void checkPartitionSizeIsPositive(int partitionSize) {
        if (partitionSize <= 0) {
            throw new IllegalArgumentException("Size of partition must be greater than zero");
        }
    }


}