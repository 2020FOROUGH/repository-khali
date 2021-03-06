package net.akaritakai.aoc2020;

import java.util.List;

public class Main {
    private static final PuzzleInputFetcher PUZZLE_INPUT_FETCHER = new PuzzleInputFetcher();
    private static final List<AbstractPuzzle> PUZZLES = List.of(
            new Puzzle01(PUZZLE_INPUT_FETCHER.getPuzzleInput(1))
    );

    public static void main(String[] args) {
        PUZZLES.forEach(puzzle -> {
            var day = String.format("%02d", puzzle.getDay());
            System.out.println("Day " + day + " Part 1: " + puzzle.solvePart1());
            System.out.println("Day " + day + " Part 2: " + puzzle.solvePart2());
        });
    }
}
