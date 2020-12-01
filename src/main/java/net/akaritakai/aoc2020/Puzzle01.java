package net.akaritakai.aoc2020;

import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Puzzle01 extends AbstractPuzzle {
    public Puzzle01(String puzzleInput) {
        super(puzzleInput);
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public String solvePart1() {
        return specialEntriesProduct(2);
    }

    @Override
    public String solvePart2() {
        return specialEntriesProduct(3);
    }

    /**
     * Finds a specified number of entries in the puzzle input that sum to 2020 and returns their product as a string.
     */
    private String specialEntriesProduct(int numEntries) {
        var combo = combinations(numEntries).filter(Puzzle01::hasSpecialSum).findAny().orElseThrow();
        return String.valueOf(product(combo));
    }

    /**
     * Returns combinations of elements (including repeats) in the puzzle input of a given size.
     */
    private Stream<Collection<Long>> combinations(int numEntries) {
        var numbers = getPuzzleInput().lines().map(Long::parseLong).collect(Collectors.toList());
        var indexes = IntStream.range(0, numbers.size()).boxed().collect(Collectors.toSet());
        @SuppressWarnings("UnstableApiUsage") var indexCombos = Sets.combinations(indexes, numEntries);
        return indexCombos.stream().map(combo -> combo.stream().map(numbers::get).collect(Collectors.toList()));
    }

    /**
     * Returns true if the numbers in the collection sum to 2020.
     */
    private static boolean hasSpecialSum(Collection<Long> collection) {
        return collection.stream().mapToLong(i -> i).sum() == 2020;
    }

    /**
     * Returns the product of the numbers in the collection.
     */
    private static long product(Collection<Long> collection) {
        return collection.stream().reduce((a, b) -> a * b).orElseThrow();
    }
}